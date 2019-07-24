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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import briix.com.movies.R;
import briix.com.movies.adapter.MovieAdapter;
import briix.com.movies.adapter.MovieSmallAdapter;
import briix.com.movies.databinding.FragmentHomeMovieBinding;
import briix.com.movies.model.Movie;
import briix.com.movies.realm.RealmController;
import briix.com.movies.realm.model.ComingMovieEntity;
import briix.com.movies.realm.model.GeneralMovieEntity;
import briix.com.movies.realm.model.PopularMovieEntity;


public class HomeMovieFragment extends Fragment implements MovieAdapter.OnItemClickListener , MovieSmallAdapter.OnItemClickListener {
    public static String TAG = "HomeMovieFragment";
    private FragmentHomeMovieBinding mBinding;
    private FragmentActivity mActivity;
    private Bundle mBundle;
    private FragmentManager mFragmentManager;
    private ArrayList<GeneralMovieEntity> movies;
    private List<Movie> mMovieList = new ArrayList<>();
    private MovieAdapter mMovieAdapter;

    private ArrayList<PopularMovieEntity> moviesPopular;
    private List<Movie> mMoviePopularList = new ArrayList<>();
    private MovieSmallAdapter mMoviePopularAdapter;


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
        initListener();

        return mBinding.getRoot();

    }

    private void initListener() {
        mMovieAdapter.setOnItemClickListener(this);
        mMoviePopularAdapter.setOnItemClickListener(this);
    }

    public void initMovies() {
        movies = RealmController.withInstance().getGeneralMovies();
        for (GeneralMovieEntity movieEntity : movies) {
            mMovieList.add(new Movie(movieEntity));
        }

        moviesPopular = RealmController.withInstance().getPopularMovies();
        for (PopularMovieEntity movieEntity : moviesPopular) {
            mMoviePopularList.add(new Movie(movieEntity));
        }
    }

    public void initRecycler() {
        mBinding.recyclerMovies.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mBinding.recyclerFavorite.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        swapItemGeneral();
        swapItemFavorite();
    }

    public void swapItemGeneral() {

        if (mMovieAdapter != null) {
            mMovieAdapter.swapItems(mMovieList);
        } else {
            mMovieAdapter = new MovieAdapter(mMovieList, getContext());
            mBinding.recyclerMovies.setAdapter(mMovieAdapter);
        }
    }

    public void swapItemFavorite() {
        if (mMoviePopularAdapter != null) {
            mMoviePopularAdapter.swapItems(mMoviePopularList);
        } else {
            mMoviePopularAdapter = new MovieSmallAdapter(mMoviePopularList, getContext());
            mBinding.recyclerFavorite.setAdapter(mMoviePopularAdapter);
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
        Toast.makeText(getActivity(), mMovie.getOriginalTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickMovie(MovieSmallAdapter.ViewHolder holder, View view, Movie mMovie) {
        Toast.makeText(getActivity(), mMovie.getOriginalTitle(), Toast.LENGTH_SHORT).show();
    }
}