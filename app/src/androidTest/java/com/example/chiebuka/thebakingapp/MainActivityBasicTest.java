package com.example.chiebuka.thebakingapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentTransaction;

import com.example.chiebuka.thebakingapp.ui.RecipeListFragment;
import com.example.chiebuka.thebakingapp.ui.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by chiebuka on 6/24/17.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityBasicTest {
    @Rule public ActivityTestRule<MainActivity> mActivityTextRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void fragment_can_be_instantiated() {
        mActivityTextRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                RecipeListFragment recipeListFragment = startRecipeListFragment();
            }
        });
        // Then use Espresso to test the Fragment
        onView(withId(R.id.recipeName)).check(matches(isDisplayed()));
    }


    private RecipeListFragment startRecipeListFragment() {
        MainActivity activity = (MainActivity) mActivityTextRule.getActivity();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        RecipeListFragment recipeListFragment = new RecipeListFragment();
        transaction.add(recipeListFragment, "recipe");
        transaction.commit();
        return recipeListFragment;
    }
}
