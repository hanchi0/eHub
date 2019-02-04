package com.jaemion.eHub.main.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.gesture.Gesture;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.jaemion.eHub.R;
import com.jaemion.eHub.application.ApplicationActivity;
import com.jaemion.eHub.customview.CustomViewPager;
import com.jaemion.eHub.main.MainActivity;
import com.jaemion.eHub.order.OrderActivity;

import static android.app.Activity.RESULT_OK;

public class MainFragment_Main extends Fragment implements  ViewPager.OnPageChangeListener{
    private MainViewModel mViewModel;
    MainFragment_Main_Adapter adapter;
    CustomViewPager pager;

    public static MainFragment_Main newInstance() {
        return new MainFragment_Main();
    }

    public MainFragment_Main() {
        super();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0){
            if(resultCode == RESULT_OK){
                if(data.getStringExtra("destination").equals("List")){
                    ((MainActivity)getActivity()).getNavigationVIew().setSelectedItemId(R.id.main_navigation_dashboard);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_container, MainFragment_List.newInstance())
                            .commitNow();
                }
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_main, container, false);
        pager = view.findViewById(R.id.main_fragment_main_viewPager);
        adapter = new MainFragment_Main_Adapter(getLayoutInflater());

        final GestureDetector gd = new GestureDetector(getContext(),new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Intent intent = null;
                //서버에서 유저 정보 받아서 수,발주 다르게
                /*if(UserDataManager.getInstance().getUserData().getUser().getUserType() == 0)
                    intent = new Intent(getActivity(), OrderActivity.class);
                else if(UserDataManager.getInstance().getUserData().getUser().getUserType() == 1)
                    intent = new Intent(getActivity(), ApplicationActivity.class);
                else
                    return;*/
                intent = new Intent(getActivity(), ApplicationActivity.class);

                switch (pager.getCurrentItem()) {
                    case 1:
                        intent.putExtra("value", 1);
                        break;
                    case 2:
                        intent.putExtra("value", 2);
                        break;
                    case 3:
                        intent.putExtra("value", 3);
                        break;
                    case 4:
                        intent.putExtra("value", 4);
                        break;
                    default:
                        return false;
                }
                startActivityForResult(intent,0);
                return true;
            }
        });
        pager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gd.onTouchEvent(event);
                return false;
            }
        });
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(this);
        pager.setClipToPadding(false);
        pager.setPageMargin(45);
        pager.setPadding(150, 0, 150, 0);
        pager.setCurrentItem(1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).getToolbarTitle().setVisibility(View.INVISIBLE);
        ((MainActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.appbar_fill_white));
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {
        if (i == ViewPager.SCROLL_STATE_IDLE) {
            if (pager.getCurrentItem() == 0) {
                pager.setCurrentItem(adapter.getCount() - 2, false);
            } else if (pager.getCurrentItem() == adapter.getCount() - 1) {
                pager.setCurrentItem(1, false);
            }
        }
    }
}
