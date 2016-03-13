package com.jat.jatumba.presentation.main.compositions;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.jat.jatumba.R;
import com.jat.jatumba.data.entity.Composition;
import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.common.Layout;
import com.jat.jatumba.presentation.main.common.BaseMainFragment;
import com.jat.jatumba.presentation.util.SimpleDividerItemDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by bulat on 22.02.16.
 */
@Layout(id = R.layout.fragment_compositions)
public class CompositionsFragment extends BaseMainFragment implements CompositionsView {
    private static final String LOG_TAG = "CompositionsFragment";
    @Inject
    CompositionsPresenter compositionsPresenter;

    @Bind(R.id.compositions_recycler_view)
    RecyclerView recyclerView;

    public CompositionsFragment() {
        Log.d(LOG_TAG, "Constructor");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_compositions, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return compositionsPresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }

    @Override
    public String getTitle() {
        return getString(R.string.compositions);
    }

    public void setCompositions(List<Composition> compositions) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CompositionsAdapter compositionsAdapter = new CompositionsAdapter(compositions);
        compositionsAdapter.setOnItemClickListener(view -> compositionsPresenter.compositionSelected((Composition) view.getTag()));
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(
                getActivity().getApplicationContext()
        ));
        recyclerView.setAdapter(compositionsAdapter);
    }
}
