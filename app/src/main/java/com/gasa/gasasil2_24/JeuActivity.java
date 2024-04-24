package com.gasa.gasasil2_24;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class JeuActivity extends AppCompatActivity {
    int[] imagePregoList = {
            R.drawable.cyril_ramaphosa,
            R.drawable.emmanuel_macron,
            R.drawable.felix_tshisekedi_rdc,
            R.drawable.ibrahim_traore,
            R.drawable.joe_biden,
            R.drawable.kim_jong_un,
            R.drawable.patrice_talon,
            R.drawable.vladmir_putine,
            R.drawable.vladmir_zelensky,
            R.drawable.ellen_johnson_sirleaf
    };
    String[] nomPregoList = {
            "Cyril Ramaphosa",
            "Emmanuel Macron",
            "Félix Tchisekedi",
            "Ibrahim Traore",
            "Joe Biden",
            "Kim Jong-un",
            "Patrice Talon",
            "Vladmir Poutin",
            "Vladmir Zelensky",
            "Johnson Sirleaf"};

    private TextView tvScore;
    private TextView tvNom;
    private ImageView imgv1;
    private ImageView imgv2;
    private ImageView imgv3;
    private ImageView imgv4;

    int indexBonneReponse;
    int positionBonneReponse;
    int indexImageInImgv1;
    int indexImageInImgv2;
    int indexImageInImgv3;
    int indexImageInImgv4;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        initView();

        nouveauJeu();
        MediaPlayer player = MediaPlayer.create(this, R.raw.back_sound);
        player.setLooping(true);
        player.start();

        imgv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (positionBonneReponse == 0) {
                    gagner();
                } else {
                    perdu();
                }
                nouveauJeu();
            }
        });
        imgv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (positionBonneReponse == 1) {
                    gagner();
                } else {
                    perdu();
                }
                tvScore.setText("Score : " + score);

                nouveauJeu();
            }
        });
        imgv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (positionBonneReponse == 2) {
                    gagner();
                } else {
                    perdu();
                }
                tvScore.setText("Score : " + score);

                nouveauJeu();
            }
        });
        imgv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (positionBonneReponse == 3) {
                    gagner();
                } else {
                    perdu();
                }
                tvScore.setText("Score : " + score);

                nouveauJeu();
            }
        });


    }

    void genererPositionBonneReponse() {
        Random random = new Random();
        positionBonneReponse = random.nextInt(4);

    }

    int genererBonneReponse(ImageView imgv) {
        Random random = new Random();
        int index = random.nextInt(imagePregoList.length);
        indexBonneReponse = index;
        imgv.setImageResource(imagePregoList[index]);
        tvNom.setText(nomPregoList[index]);
        return index;
    }

    int generer(ImageView imgv) {
        int index = -1;
        do {
            Random random = new Random();
            index = random.nextInt(imagePregoList.length);
        } while (index == indexImageInImgv1 || index == indexImageInImgv2 || index == indexImageInImgv3 || index == indexImageInImgv4);

        imgv.setImageResource(imagePregoList[index]);
        return index;
    }

    void nouveauJeu() {
        genererPositionBonneReponse();
        if (positionBonneReponse == 0) {
            indexImageInImgv1 = genererBonneReponse(imgv1);
            indexImageInImgv2 = generer(imgv2);
            indexImageInImgv3 = generer(imgv3);
            indexImageInImgv4 = generer(imgv4);
        } else if (positionBonneReponse == 1) {
            indexImageInImgv2 = genererBonneReponse(imgv2);
            indexImageInImgv1 = generer(imgv1);
            indexImageInImgv3 = generer(imgv3);
            indexImageInImgv4 = generer(imgv4);
        } else if (positionBonneReponse == 2) {
            indexImageInImgv3 = genererBonneReponse(imgv3);
            indexImageInImgv1 = generer(imgv1);
            indexImageInImgv2 = generer(imgv2);
            indexImageInImgv4 = generer(imgv4);
        } else if (positionBonneReponse == 3) {
            indexImageInImgv4 = genererBonneReponse(imgv4);
            indexImageInImgv1 = generer(imgv1);
            indexImageInImgv2 = generer(imgv2);
            indexImageInImgv3 = generer(imgv3);
        }
    }

    void gagner() {
        MediaPlayer player = MediaPlayer.create(this, R.raw.gagner);
        player.start();
        score += 5;
        tvScore.setText("Score : " + score);


    }

    void perdu() {
        if (score > 0) {
            score -= 1;

        }
        tvScore.setText("Score : " + score);
        MediaPlayer player = MediaPlayer.create(this, R.raw.perdu);
        player.start();


    }

    private void initView() {
        tvScore = findViewById(R.id.tv_score);
        tvNom = findViewById(R.id.tv_nom);
        imgv1 = findViewById(R.id.imgv_1);
        imgv2 = findViewById(R.id.imgv_2);
        imgv3 = findViewById(R.id.imgv_3);
        imgv4 = findViewById(R.id.imgv_4);
    }
}