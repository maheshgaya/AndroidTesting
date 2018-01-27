package com.maheshgaya.android.testspike.model;

import android.os.Parcel;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class ItemTest {
    private static final String DESCRIPTION = "description";
    private static final String TITLE = "title";
    private Item item;

    @Before
    public void setUp() throws Exception {
        item = new Item();
    }

    @Test
    public void itemIsParceled() throws Exception {
        item.setTitle(TITLE);
        item.setDescription(DESCRIPTION);

        Parcel parcel = Parcel.obtain();
        item.writeToParcel(parcel, item.describeContents());

        parcel.setDataPosition(0);

        Item itemParcel = Item.CREATOR.createFromParcel(parcel);

        assertThat(itemParcel.getDescription(), is(DESCRIPTION));
        assertThat(itemParcel.getTitle(), is(TITLE));
    }
}