package com.wakecap.android.assignment.ui.workersList;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wakecap.android.assignment.R;
import com.wakecap.android.assignment.models.BaseItem;
import com.wakecap.android.assignment.models.WorkerAttributes;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.List;

/**
 *
 */
public class JavaFragment extends Fragment implements JavaContract.View {


    @Inject
    JavaPresenter presenter;
    View rootView;

    public JavaFragment() {
        // Required empty public constructor
    }


    public static JavaFragment newInstance() {
        return new JavaFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_java, container, false);
        return rootView;
    }

    @Override
    public void initViews() {
        presenter.downloadDataFromApi();
    }

    @Override
    public boolean isOnline() {
        return false;
    }

    @Override
    public void showLoading(boolean showHide) {

    }

    @Override
    public void workersListDataReady(@NotNull List<BaseItem<WorkerAttributes>> items) {

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
