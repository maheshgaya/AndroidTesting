package com.maheshgaya.android.testspike.adapter;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.maheshgaya.android.testspike.MainActivity;
import com.maheshgaya.android.testspike.R;
import com.maheshgaya.android.testspike.model.Item;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class ListAdapterTest {
    public static final RecyclerView recyclerView = new RecyclerView(InstrumentationRegistry.getTargetContext());
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    private ListAdapter<Item> adapter;

    @Before
    public void setUp() {
        adapter = new ListAdapter<>(R.layout.layout_item, getList());
        recyclerView.setLayoutManager(new LinearLayoutManager(InstrumentationRegistry.getTargetContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.measure(View.MeasureSpec.AT_MOST, View.MeasureSpec.AT_MOST);
        recyclerView.layout(0, 0, 800, 480);
    }

    @Test
    public void rvIsNotEmtpy() {
        assertThat(recyclerView.getChildCount(), is(greaterThan(0)));
    }

    @Test
    public void viewHasItem1FromList() {
        RecyclerView.ViewHolder vh = recyclerView.findViewHolderForLayoutPosition(0);

        assertThat(vh.itemView, hasDescendant(withText("title1")));
        assertThat(vh.itemView, hasDescendant(withText("desc1")));
    }

    @Test
    public void viewHasList() {
        for (int i = 0; i < adapter.getItemCount(); i++) {
            Item item = ((ListAdapter) recyclerView.getAdapter()).getItem(i);
            int position = i + 1;
            assertThat(item.getTitle(), is("title" + position));
            assertThat(item.getDescription(), is("desc" + position));
        }
    }

    private List<Item> getList() {
        return Arrays.asList(
                new Item("title1", "desc1"),
                new Item("title2", "desc2"),
                new Item("title3", "desc3"),
                new Item("title4", "desc4"),
                new Item("title5", "desc5")
        );
    }
}