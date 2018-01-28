package com.maheshgaya.android.testspike.adapter;

import com.maheshgaya.android.testspike.R;
import com.maheshgaya.android.testspike.model.Item;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ListAdapterTest {

    private List<Item> itemList;
    private ListAdapter<Item> listAdapter;

    @Before
    public void setUp() {
        itemList = getList();
        listAdapter = new ListAdapter<>(R.id.recycler_view, itemList);
    }

    @Test
    public void getCountReturnsSizeOfList() {
        assertThat(itemList.size(), is(listAdapter.getItemCount()));
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