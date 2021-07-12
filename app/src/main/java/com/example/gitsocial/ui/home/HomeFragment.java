package com.example.gitsocial.ui.home;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.gitsocial.R;

import timber.log.Timber;

/**
 * A fragment representing a list of Items.
 */
public class HomeFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    public static final int PICK_CONTACT_REQUEST_CODE = 200;
    public static final String TAG = HomeFragment.class.getSimpleName();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public HomeFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Set the adapter
        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));

        // download
        String token = getString(R.string.github_token);
        String url = "https://api.github.com/users/ShukranIsaac/followers?token" + token;
        Downloader.builder()
                .context(requireActivity())
                .progressBar(view.findViewById(R.id.progress_bar))
                .view(recyclerView)
                .url(url)
                .download();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.home_app_bar_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.search) {
            requireActivity().onSearchRequested();
            // Associate searchable configuration with the SearchView
            SearchManager searchManager = (SearchManager) requireContext().getSystemService(Context.SEARCH_SERVICE);
            SearchView searchView = (SearchView) item.getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(requireActivity().getComponentName()));
        }
        return super.onOptionsItemSelected(item);
    }

    // Create an intent to "pick" a contact, as defined by the content provider URI
    private void pickContact() {
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, PICK_CONTACT_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String[] fromColumns = {
                ContactsContract.Data.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER
        };

        int[] toViews = {};

        // If the request went well (OK) and the request was PICK_CONTACT_REQUEST
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_CONTACT_REQUEST_CODE) {

            // Perform a query to the contact's content provider for the contact's name
            Cursor cursor = requireActivity().getContentResolver().query(data.getData(),
                    new String[] {ContactsContract.Contacts.DISPLAY_NAME},
                    null, null, null);

            /*SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.person_name_and_number,
                    cursor, fromColumns, toViews, 0);*/

            if (cursor.moveToFirst()) { // True if the cursor is not empty
                int columnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                String name = cursor.getString(columnIndex);
                // Do something with the selected contact's name...
                Timber.d("PICKED_CONTACT_NAME => %s", name);
            }
        }
    }
}