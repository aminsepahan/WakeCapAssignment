package com.wakecap.android.assignment.ui.javaList;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.florent37.viewanimator.AnimationListener;
import com.github.florent37.viewanimator.ViewAnimator;
import com.wakecap.android.assignment.R;
import com.wakecap.android.assignment.models.BaseItem;
import com.wakecap.android.assignment.models.WorkerAttributes;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

/**
 *
 */
public class JavaFragment extends Fragment implements JavaContract.View {


    private JavaPresenter presenter;
    private View rootView;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    public JavaFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        progressBar = rootView.findViewById(R.id.progress);
        recyclerView = rootView.findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        presenter = new JavaPresenter();
        presenter.attach(this);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void initViews() {
        presenter.downloadDataFromApi();
    }


    @Override
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) Objects.requireNonNull(getActivity()).getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return (netInfo != null && netInfo.isConnectedOrConnecting());
    }

    @Override
    public void showLoading(boolean showHide) {
        if (showHide) {
            ViewAnimator.animate(progressBar)
                    .fadeIn()
                    .duration(400)
                    .onStart(new AnimationListener.Start() {
                        @Override
                        public void onStart() {
                            progressBar.setVisibility(View.VISIBLE);
                        }
                    }).start();
        } else {
            ViewAnimator.animate(progressBar)
                    .fadeOut()
                    .duration(400)
                    .onStop(new AnimationListener.Stop() {
                        @Override
                        public void onStop() {
                            progressBar.setVisibility(View.GONE);
                        }
                    }).start();
        }
    }

    @Override
    public void workersListDataReady(@NotNull List<BaseItem<WorkerAttributes>> items) {

        JavaListAdapter adapter = new JavaListAdapter(items);
//        recyclerView.addItemDecoration(new ItemDecorationPadding(10));
        recyclerView.setAdapter(adapter);
        ViewAnimator.animate(recyclerView).slideBottomIn().duration(400).start();

    }

    @Override
    public void dataError(@NotNull String error) {

    }

    @NotNull
    @Override
    public String getStringFromRes(@StringRes int i) {
        return getString(i);
    }
}
