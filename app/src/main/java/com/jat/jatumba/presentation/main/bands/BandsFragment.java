package com.jat.jatumba.presentation.main.bands;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.jat.jatumba.R;
import com.jat.jatumba.data.entity.Band;
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
@Layout(id = R.layout.fragment_bands)
public class BandsFragment extends BaseMainFragment implements BandsView {
    private static final String LOG_TAG = "BandsFragment";
    @Inject
    BandsPresenter bandsPresenter;

    @Bind(R.id.bands_recycler_view)
    RecyclerView recyclerView;

    public BandsFragment() {
        Log.d(LOG_TAG, "Constructor");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_bands, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return bandsPresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }

    @Override
    public String getTitle() {
        return "Bands";
    }

    public void setBands(List<Band> bands) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        BandsAdapter bandsAdapter = new BandsAdapter(bands);
        bandsAdapter.setOnItemClickListener(view -> bandsPresenter.bandSelected((Band) view.getTag()));
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(
                getActivity().getApplicationContext()
        ));
        recyclerView.setAdapter(bandsAdapter);
    }
}
