package com.example.platzigram.post.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.navigation.FloatingWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.platzigram.Adapter.PictureAdapterRecyclerView;
import com.example.platzigram.R;
import com.example.platzigram.model.Picture;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final int REQUEST_CAMERA = 1;
    private FloatingActionButton fabCamera;
    private String photoPathTemp="";

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.tab_home),false,view);
        RecyclerView picturesRecycler=view.findViewById(R.id.pictureRecycler);
        fabCamera=view.findViewById(R.id.fabCamera);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView=new PictureAdapterRecyclerView(buidPictures(),R.layout.cardview_picture,getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });

        return view;
    }

    private void takePicture() {

        Intent intentTkePicture=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intentTkePicture.resolveActivity(getActivity().getPackageManager())!=null){
            File photoFile=null;
            try {
                photoFile=createImageFile();
            }catch (Exception e){
                e.printStackTrace();
            }
            if(photoFile!=null){
                Uri photoUri= FileProvider.getUriForFile(getActivity(),"com.example.platzigram",photoFile);
                intentTkePicture.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                startActivityForResult(intentTkePicture,REQUEST_CAMERA);
            }

        }

    }

    private File createImageFile() throws IOException {

        String timeStamp=new SimpleDateFormat("yyyyMMdd_HH-mm-ss").format(new Date());
        String imageFileName="JPEG"+timeStamp+"_";
        File storageDirectory=getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File photo=File.createTempFile(imageFileName,".jpg",storageDirectory);

        photoPathTemp="file:"+photo.getAbsolutePath();

        return photo;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_CAMERA&&resultCode==getActivity().RESULT_OK){
            Log.d("HomeFragment","Camera Ok!! :");
            Intent i=new Intent(getActivity(),NewPostActivity.class);
            i.putExtra("PHOTO_PATH_TEMP",photoPathTemp);
            startActivity(i);
        }
    }

    public ArrayList<Picture> buidPictures(){
        ArrayList<Picture> pictures=new ArrayList<>();
        pictures.add(new Picture("https://images.pexels.com/photos/821406/pexels-photo-821406.jpeg","Dariana","2 dias","4 Me gusta"));
        pictures.add(new Picture("https://i.ibb.co/4Rx3FWf/94887700-546697096242026-6649823046066503680-n.jpg","Joselyn","5 dias","5 Me gusta"));
        pictures.add(new Picture("https://i.imgur.com/vCAtpkU.jpg","Cataleya","4 dias","2 Me gusta"));

        return pictures;
    }

    public void showToolbar(String tittle,boolean upButton,View view){

        Toolbar toolbar=view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);


    }

}
