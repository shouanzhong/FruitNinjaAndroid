package com.example.fruitninja.ui;

import android.app.Activity;
import android.os.Bundle;
//import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.fruitninja.R;

public class GameFragment extends Fragment {

    private OnGameOver gameOverListener;

    public interface OnGameOver {
	public void onGameOver(int score);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	View v = inflater.inflate(R.layout.fragment_game, null);

	GameSurfaceView gameView = (GameSurfaceView) v.findViewById(R.id.gameview);
	gameView.setGameOverListener(gameOverListener);
	
	return v;
    }

    @Override
    public void onAttach(Activity activity) {
	super.onAttach(activity);

	try {
	    gameOverListener = (OnGameOver) activity;
	} catch (ClassCastException e) {
	    throw new ClassCastException(activity.toString() + " must implement OnGameOver");
	}
    }
}