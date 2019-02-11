package com.jaemion.eHub.main.ui;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.jaemion.eHub.R;
import com.jaemion.eHub.main.MainActivity;
import com.jaemion.eHub.orderdetail.OrderDetailActivity;


public class MainFragment_List extends Fragment {
    private MainViewModel mViewModel;

    public static MainFragment_List newInstance() {
        return new MainFragment_List();
    }

    public MainFragment_List() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.main_fragment_list_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        MainFragment_List_Adapter adapder = new MainFragment_List_Adapter(getContext());
        recyclerView.setAdapter(adapder);
        final GestureDetector gd = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                View v = rv.findChildViewUnder(e.getX(), e.getY());
                if (v != null && gd.onTouchEvent(e)) {
                    Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                    intent.putExtra("position", rv.getChildAdapterPosition(v));
                    startActivity(intent);
                    //뷰홀더 순서 구할 수 있음 나중에 서버에서 받아온 리스트 이 값으로 뽑아서 프래그먼트 넘겨주면됨
                    //rv.getChildAdapterPosition(v)
                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }
        });
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
        ((MainActivity)getActivity()).getToolbarTitle().setVisibility(View.VISIBLE);
        ((MainActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.appbar_border));
    }
}
