package com.example.pruebas;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GaleriaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GaleriaFragment extends Fragment {

    private Button efecto, musica;
    private View vista;
    private SoundPool sp;
    private MediaPlayer mp;
    int sonido_de_Reproduccion;
    boolean reproducir;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GaleriaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GaleriaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GaleriaFragment newInstance(String param1, String param2) {
        GaleriaFragment fragment = new GaleriaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_galeria,container,false);

        efecto = (Button) vista.findViewById(R.id.button2);
        musica = (Button) vista.findViewById(R.id.button3);

        reproducir = false;

        efecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Reproduccion de efecto.", Toast.LENGTH_SHORT).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    AudioAttributes atributos = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION).setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();
                    sp = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(atributos).build();
                }else{
                    sp = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
                }
                sonido_de_Reproduccion = sp.load(getContext(),R.raw.muertesnake,1);
                sp.play(sonido_de_Reproduccion, 1, 1, 1, 0, 1);
            }
        });

        musica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!reproducir){
                    Toast.makeText(getActivity(), "Reproduciendo.", Toast.LENGTH_SHORT).show();
                    mp = MediaPlayer.create(getContext(), R.raw.surprisebuttsecks);
                    mp.start();
                    reproducir = true;
                }else{
                    mp.stop();
                    Toast.makeText(getActivity(), "Detenido.", Toast.LENGTH_SHORT).show();
                    reproducir = false;
                }
            }
        });
        return vista;
    }
}