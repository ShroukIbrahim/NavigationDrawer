package moshrouk.android.example.com.navigationdrawer;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<Itemlist> itemlists;
    DrawerLayout dLayout;
    ActionBarDrawerToggle dToggle;


    // index to identify current nav menu item
    public static int navItemIndex = 0;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//*****************************RecyclerView*********************
        recyclerView = (RecyclerView) findViewById(R.id.Recyclerview);
        //recyclerView.setHasFixedSize(true);
        //Then we do a setLayoutManager
        // LinearLayoutManager>>which is to make the Recycler display the items horizontally one under the other
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemlists = new ArrayList<>();

        for (int i = 0; i<=20 ; i++) {
            Itemlist itemlist =new Itemlist(

                    "Head " + i,
                    "Description .............");


            itemlists.add(itemlist);

        }
        adapter =new RecyclerAdabter(itemlists,this);
        recyclerView.setAdapter(adapter);



//**********************End Recyclerview*************************

        //create navigationDrawer
        setNavigationDrawer();
    }



    //Navigation View

    public void setNavigationDrawer() {
        dLayout = (DrawerLayout) findViewById(R.id.drawer); // initiate a DrawerLayout
        NavigationView navView = (NavigationView) findViewById(R.id.navigation_view); // initiate a Navigation View
        dToggle = new ActionBarDrawerToggle(this,dLayout,R.string.open,R.string.close);
        dLayout.addDrawerListener(dToggle);
        dToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        // implement setNavigationItemSelectedListener event on NavigationView
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                Fragment frag = null; // create a Fragment Object
                int itemId = menuItem.getItemId(); // get selected menu item's id

                // check selected menu item's id and replace a Fragment Accordingly
                if (itemId == R.id.nav_home)
                {
                    navItemIndex = 0;
                }

                else if (itemId == R.id.nav_profil)
                {
                    navItemIndex = 1;

                }

                else if (itemId == R.id.nav_Consultants) {

                    navItemIndex = 2;
                }

                else if (itemId == R.id.nav_Contractors) {

                    navItemIndex = 3;
                }
                else if (itemId == R.id.nav_Suppliers) {

                    navItemIndex = 4;

                }

                else if (itemId == R.id.nav_Massage) {

                    navItemIndex = 5;

                }

                else if (itemId == R.id.nav_notifications) {

                    navItemIndex = 6;

                }
                else if (itemId == R.id.nav_settings) {

                    navItemIndex = 7;
                }


                else if (itemId == R.id.nav_About) {

                    navItemIndex = 8;
                }

                else if (itemId == R.id.nav_contanus) {

                    navItemIndex = 9;
                }


                if (frag != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, frag);// replace a Fragment with Frame Layout
                    transaction.commit(); // commit the changes
                    dLayout.closeDrawers(); // close the all open Drawer Views
                    return true;
                }
                return false;
            }
        });

    }


}