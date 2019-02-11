package com.jaemion.eHub.application.ui;

import androidx.lifecycle.ViewModelProviders;

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
import com.jaemion.eHub.application.ApplicationActivity;


public class ApplicationFragment_List extends Fragment {

    private ApplicationViewModel mViewModel;

    public static ApplicationFragment_List newInstance() {
        return new ApplicationFragment_List();
    }
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.application_fragment_list, container, false);
        recyclerView = view.findViewById(R.id.application_fragment_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        ApplicationFragment_List_Adapter adapter = new ApplicationFragment_List_Adapter(getContext());
        recyclerView.setAdapter(adapter);
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
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.application_container,ApplicationFragment_Detail.newInstance())
                            .commit();
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
        mViewModel = ViewModelProviders.of(this).get(ApplicationViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ApplicationActivity)getActivity()).setToolbar("발주된 작업 목록");
        ((ApplicationActivity)getActivity()).getSupportActionBar().show();
    }
}
