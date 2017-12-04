package my.edu.tarc.lab33navigationdrawer;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.locks.ReadWriteLock;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {
    private ImageView imageViewPhoto;

    public static final int REQUEST_PICK = 0;
    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);

        imageViewPhoto = (ImageView)v.findViewById(R.id.ImageViewPhoto);
        Button buttonGetFile = (Button)v.findViewById(R.id.buttonGetFile);
        buttonGetFile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                startActivityForResult(intent, REQUEST_PICK);
            }

        });
        // Inflate the layout for this fragment
        return v;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_PICK && resultCode == RESULT_OK) {
            Uri uri = null;
            if (data!= null){
                uri = data.getData();
                imageViewPhoto.setImageURI(uri);
            }
        }
    }

}
