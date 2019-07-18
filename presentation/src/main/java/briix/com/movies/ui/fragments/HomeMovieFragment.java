package briix.com.movies.ui.fragments;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import briix.com.movies.R;
import briix.com.movies.adapter.MovieAdapter;
import briix.com.movies.data.Preferences;
import briix.com.movies.databinding.FragmentHomeMovieBinding;
import briix.com.movies.model.Movie;
import briix.com.movies.realm.RealmController;
import briix.com.movies.realm.model.ComingMovieEntity;


public class HomeMovieFragment extends Fragment implements MovieAdapter.OnItemClickListener {
    public static String TAG = "HomeMovieFragment";
    private FragmentHomeMovieBinding mBinding;
    private FragmentActivity mActivity;
    private Bundle mBundle;
    private FragmentManager mFragmentManager;
    private ArrayList<ComingMovieEntity> movies;
    private List<Movie> mMovieList = new ArrayList<>();
    private MovieAdapter mMovieAdapter;

    private Preferences mPreferences;


    public HomeMovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = new Bundle();
        mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_movie, container, false);

        initMovies();
        initRecycler();

        return mBinding.getRoot();

    }

    public void initMovies() {
        movies = RealmController.withInstance().getPopularMovies();
        for (ComingMovieEntity movieEntity : movies) {
            mMovieList.add(new Movie(movieEntity));
        }
    }

    public void initRecycler() {
        mBinding.recyclerMovies.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        swapItemFilterDay();
    }

    public void swapItemFilterDay() {

        if (mMovieAdapter != null) {
            mMovieAdapter.swapItems(mMovieList);
        } else {
            mMovieAdapter = new MovieAdapter(mMovieList, getContext());
            mBinding.recyclerMovies.setAdapter(mMovieAdapter);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void loadArguments() {
        mBundle = getArguments();
        if (mBundle != null) {
            //
        }
    }


    DialogInterface.OnClickListener coexistenceListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        }
    };

    @Override
    public void onClickMovie(MovieAdapter.ViewHolder holder, View view, Movie mMovie) {

    }
}