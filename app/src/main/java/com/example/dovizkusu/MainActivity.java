package com.example.dovizkusu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SharedMemory;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.flarebit.flarebarlib.FlareBar;
import com.flarebit.flarebarlib.Flaretab;
import com.flarebit.flarebarlib.TabEventObject;
import org.json.JSONObject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    ScrollView layoutDovizLY,layoutAltinLY;
    FrameLayout mainScreenLY,firstScreenLY;
    LinearLayout ilkkisimLY,ikincikisimLY,sonkisimLY,lottiButtonsLY,baslangicLY,userInterfaceLY;


    LottieAnimationView refreshLT,refresh2LT,maleLT,femaleLT,greatLT,leftArrowLT,righArrowLT,tickLT,crossLT,doktorLT,muhendisLT,isadamiLT,calisanLT,ogrenciLT,digerLT,bottomArrowLT,bottomArrowLT2,
            doktorkarsilamaLT,muhendisKarsilamaLT,isadamiKarsilamaLT,calisanKarsilamaLT,ogrenciKarsilamaLT,digerKarsilamaLT,doktorkarsilamaLT2,muhendisKarsilamaLT2,isadamiKarsilamaLT2,calisanKarsilamaLT2,
            ogrenciKarsilamaLT2,digerKarsilamaLT2,iskadinikarsilamaLT,iskadinikarsilamaLT2,digerKadinKarsilamaLT,digerKadinKarsilamaLT2,digerKadinLT,iskadiniLT;

    TextView ilksoruTV,ikincisoruTV,sonsoruTV,atlaTV,onaylaTV,baslaTV,karsilaTV,dovizScreenKarsilamaTV,altinScreenKarsilamaTV;
    ImageView doktorIMG,muhendisIMG,isadamiIMG,calisanIMG,ogrenciIMG,digerIMG;
    EditText isimaliciET;

    TextView abd_dollar,au_dollar,cad_dollar,euro,sterlin,frang,yuan,yen,dan_kron,kuvety_dinar,ruble,suudi_riyal,isvicre_kron,katar_riyal,iran_riyal,bulgar_leva,norvec_kron,pakistan_rupi;
    TextView gram_altin,yarim_altin,tam_altin,cmhr_altin,ons_altin,ata_altin,onsekiz_altin,ondort_altin,yirmiiki_bilezik,resat_altin,hamit_altin,gremse_altin,besli_altin,ikibucuk_altin,gumus,ceyrek_altin;
    TextView guncelleme_tarihi;
    String sistemSaati,sistemTarihi,isimSTR,meslekSTR;

    SharedPreferences cinsiyetSP,isimSP,meslekSP,isOkaySP;

    int hour,minute,year,month,day ;
    int meslekInt=0;
    boolean maleBool,firstScreenisCompleted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Doviz altın arka plan tanımlamaları
        refreshLT=(LottieAnimationView) findViewById(R.id.refresh_button);
        abd_dollar=(TextView) findViewById(R.id.abd_dollar_text);
        au_dollar=(TextView) findViewById(R.id.au_dollar_text);
        cad_dollar=(TextView) findViewById(R.id.cnd_dollar_text);
        sterlin=(TextView) findViewById(R.id.sterlin_text);
        euro=(TextView) findViewById(R.id.euro_text);
        frang=(TextView) findViewById(R.id.frang_text);
        yuan=(TextView) findViewById(R.id.yuan_text);
        yen=(TextView) findViewById(R.id.japon_text);
        dan_kron=(TextView) findViewById(R.id.dan_kronu_text);
        kuvety_dinar=(TextView) findViewById(R.id.dinar_text);
        ruble=(TextView) findViewById(R.id.ruble_text);
        suudi_riyal=(TextView) findViewById(R.id.riyal_text);
        isvicre_kron=(TextView) findViewById(R.id.isvicre_kron_text);
        katar_riyal=(TextView) findViewById(R.id.katar_riyal_text);
        iran_riyal=(TextView) findViewById(R.id.iran_riyal_text);
        bulgar_leva=(TextView) findViewById(R.id.bulgar_leva_text);
        norvec_kron=(TextView) findViewById(R.id.nor_kron_text);
        pakistan_rupi=(TextView) findViewById(R.id.pakistan_rupi_text);

        refresh2LT=(LottieAnimationView) findViewById(R.id.refresh_button2);
        gram_altin=(TextView)findViewById(R.id.gram_altin_text);
        ceyrek_altin=(TextView)findViewById(R.id.ceyrek_altin_text);
        yarim_altin=(TextView)findViewById(R.id.yarim_altin_text);
        tam_altin=(TextView)findViewById(R.id.tam_altin_text);
        cmhr_altin=(TextView)findViewById(R.id.cmhr_altin_text);
        ons_altin=(TextView)findViewById(R.id.ons_altin_text);
        ata_altin=(TextView)findViewById(R.id.ata_altin_text);
        onsekiz_altin=(TextView)findViewById(R.id.onsekiz_altin_text);
        ondort_altin=(TextView)findViewById(R.id.ondort_altin_text);
        yirmiiki_bilezik=(TextView)findViewById(R.id.yirmiiki_bilezik_text);
        resat_altin=(TextView)findViewById(R.id.resat_altin_text);
        hamit_altin=(TextView)findViewById(R.id.hamit_altin_text);
        gremse_altin=(TextView)findViewById(R.id.gremse_altin_text);
        besli_altin=(TextView)findViewById(R.id.besli_altin_text);
        ikibucuk_altin=(TextView)findViewById(R.id.ikibucuk_altin_text);
        gumus=(TextView)findViewById(R.id.gumus_text);
        //Doviz altın arka plan tanımlamalarının bitişi



        //İlk Ekran Tanımlamaları
        baslangicLY = (LinearLayout) findViewById(R.id.baslangicSorusuLayout);
        ilkkisimLY = (LinearLayout) findViewById(R.id.ilkkisim);
        ikincikisimLY=(LinearLayout)findViewById(R.id.ikincikisim);
        sonkisimLY=(LinearLayout) findViewById(R.id.sonkisim);
        userInterfaceLY=(LinearLayout) findViewById(R.id.userInterfaceLY);
        lottiButtonsLY = (LinearLayout) findViewById(R.id.lottieButtonsLayout);

        tickLT=(LottieAnimationView) findViewById(R.id.tick_json);
        crossLT=(LottieAnimationView) findViewById(R.id.cross_json);
        maleLT=(LottieAnimationView) findViewById(R.id.male_json);
        femaleLT=(LottieAnimationView) findViewById(R.id.female_json);
        righArrowLT=(LottieAnimationView)findViewById(R.id.rightArrowLottie);
        leftArrowLT=(LottieAnimationView)findViewById(R.id.leftArrowLottie);
        greatLT=(LottieAnimationView) findViewById(R.id.greatLottie);
        doktorLT=(LottieAnimationView) findViewById(R.id.doktorLottie);
        muhendisLT=(LottieAnimationView) findViewById(R.id.muhendisLottie);
        isadamiLT=(LottieAnimationView) findViewById(R.id.isadamiLottie);
        calisanLT=(LottieAnimationView) findViewById(R.id.calisanLottie);
        ogrenciLT=(LottieAnimationView) findViewById(R.id.ogrenciLottie);
        digerLT=(LottieAnimationView) findViewById(R.id.digerLottie);
        bottomArrowLT=(LottieAnimationView) findViewById(R.id.bottomArrowJson);
        bottomArrowLT2=(LottieAnimationView) findViewById(R.id.bottomArrowJson2);
        doktorkarsilamaLT=(LottieAnimationView) findViewById(R.id.doktorKarsilamaJson);
        muhendisKarsilamaLT=(LottieAnimationView) findViewById(R.id.muhendisKarsilamaJson);
        isadamiKarsilamaLT=(LottieAnimationView) findViewById(R.id.isadamiKarsilamaJson);
        calisanKarsilamaLT=(LottieAnimationView) findViewById(R.id.calisanKarsilamaJson);
        ogrenciKarsilamaLT=(LottieAnimationView) findViewById(R.id.ogrenciKarsilamaJson);
        digerKarsilamaLT=(LottieAnimationView) findViewById(R.id.digerErkekKarsilamaJson);
        digerKadinLT=(LottieAnimationView) findViewById(R.id.digerKadinLottie);

        doktorkarsilamaLT2=(LottieAnimationView) findViewById(R.id.doktorKarsilamaJson2);
        muhendisKarsilamaLT2=(LottieAnimationView) findViewById(R.id.muhendisKarsilamaJson2);
        isadamiKarsilamaLT2=(LottieAnimationView) findViewById(R.id.isadamiKarsilamaJson2);
        calisanKarsilamaLT2=(LottieAnimationView) findViewById(R.id.calisanKarsilamaJson2);
        ogrenciKarsilamaLT2=(LottieAnimationView) findViewById(R.id.ogrenciKarsilamaJson2);
        digerKarsilamaLT2=(LottieAnimationView) findViewById(R.id.digerKarsilamaJson2);
        digerKadinKarsilamaLT=(LottieAnimationView)findViewById(R.id.digerKadinKarsilamaJson);
        digerKadinKarsilamaLT2=(LottieAnimationView)findViewById(R.id.digerKadinKarsilamaJson2);
        iskadinikarsilamaLT=(LottieAnimationView) findViewById(R.id.iskadiniKarsilamaJson);
        iskadinikarsilamaLT2=(LottieAnimationView) findViewById(R.id.iskadiniKarsilamaJson2);
        iskadiniLT=(LottieAnimationView) findViewById(R.id.isKadiniLottie);

        maleLT.setMinAndMaxFrame(10,100);
        femaleLT.setMinAndMaxFrame(25,100);

        baslaTV=(TextView) findViewById(R.id.baslangicSorusuTV);
        ilksoruTV=(TextView) findViewById(R.id.cinsiyet_textview);
        ikincisoruTV=(TextView) findViewById(R.id.isim_textview);
        isimaliciET=(EditText) findViewById(R.id.isimalici);
        sonsoruTV=(TextView) findViewById(R.id.meslek_textview);
        karsilaTV=(TextView) findViewById(R.id.karsilamaText);


        doktorIMG = (ImageView) findViewById(R.id.doktor);
        muhendisIMG = (ImageView) findViewById(R.id.muhendis);
        isadamiIMG = (ImageView) findViewById(R.id.isadami);
        calisanIMG = (ImageView) findViewById(R.id.calisan);
        ogrenciIMG = (ImageView) findViewById(R.id.ogrenci);
        digerIMG = (ImageView) findViewById(R.id.diger);


        cinsiyetSP = this.getSharedPreferences("com.example.dovizkusu", Context.MODE_PRIVATE);
        isimSP = this.getSharedPreferences("com.example.dovizkusu", Context.MODE_PRIVATE);
        meslekSP= this.getSharedPreferences("com.example.dovizkusu", Context.MODE_PRIVATE);
        isOkaySP = this.getSharedPreferences("com.example.dovizkusu", Context.MODE_PRIVATE);
       //ilk Ekran tanımlamalarının bitişi

        dovizScreenKarsilamaTV=(TextView) findViewById(R.id.dovizScreenKarsilamaText);
        altinScreenKarsilamaTV=(TextView) findViewById(R.id.altinScreenKarsilamaText);


        firstScreenLY = (FrameLayout) findViewById(R.id.FirstScreenLayout);
        layoutDovizLY = (ScrollView) findViewById(R.id.dovizScreenLayout);
        layoutAltinLY = (ScrollView) findViewById(R.id.altinScreenLayout);

        getSaves();
        firstScreenControl();
        getRates(bulgar_leva);
        hideDefaultNavBar();
        createBottomMenu();

    }

    public void firstScreenControl(){
        hideDefaultNavBar();
        if(isimSTR!=null && meslekSTR!=null){
            baslangicLY.setVisibility(View.INVISIBLE);
            ilkkisimLY.setVisibility(View.INVISIBLE);
            ikincikisimLY.setVisibility(View.INVISIBLE);
            sonkisimLY.setVisibility(View.INVISIBLE);
            setUserInterface();
        }
        else
            baslangicLY.setVisibility(View.VISIBLE);
            layoutAltinLY.setVisibility(View.INVISIBLE);
            layoutDovizLY.setVisibility(View.INVISIBLE);
    }
    public void tickClicked(View view){
        hideDefaultNavBar();
        maleBool=true;
        isimSTR=null;
        meslekSTR=null;
        meslekInt=0;
        doktorLT.setVisibility(View.INVISIBLE);
        muhendisLT.setVisibility(View.INVISIBLE);
        isadamiLT.setVisibility(View.INVISIBLE);
        calisanLT.setVisibility(View.INVISIBLE);
        ogrenciLT.setVisibility(View.INVISIBLE);
        digerLT.setVisibility(View.INVISIBLE);
        baslangicLY.setVisibility(View.INVISIBLE);
        ilkkisimLY.setVisibility(View.VISIBLE);
    }
    public void crossClicked(View view){
        hideDefaultNavBar();
        baslangicLY.setVisibility(View.INVISIBLE);
        lottiButtonsLY.setVisibility(View.VISIBLE);
    }
    public void maleClicked(View view){
        hideDefaultNavBar();
        maleBool = true;
        ilkkisimLY.setVisibility(View.INVISIBLE);
        ikincikisimLY.setVisibility(View.VISIBLE);
        editTextisOkey();
    }
    public void femaleClicked(View view){
        hideDefaultNavBar();
        maleBool=false;
        //cinsiyetSP.edit().putBoolean("cinsiyetKaydi",maleBool).apply();
        // soundGroup1Cursiors = sharedPreferences4.getInt("savedChoose",0);
        ilkkisimLY.setVisibility(View.INVISIBLE);
        ikincikisimLY.setVisibility(View.VISIBLE);
        editTextisOkey();
    }
    public void editTextisOkey() {
        hideDefaultNavBar();
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                hideDefaultNavBar();
                isimaliciET.setError("Lütfen "+millisUntilFinished/1000+" Saniye içinde"+"Alanı Doldurunuz");
            }
            @Override
            public void onFinish() {
                hideDefaultNavBar();
                isimaliciET.setError("");
                isimSTR = isimaliciET.getText().toString();
                if (!isimSTR.toString().isEmpty()) {
                    ikincikisimLY.setVisibility(View.INVISIBLE);
                    sonkisimLY.setVisibility(View.VISIBLE);
                }
                else if (isimSTR.toString().isEmpty()) {
                    layoutDovizLY.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Kişisel Bilgiler Alinmadi",Toast.LENGTH_SHORT).show();
                }
            }
        }.start();
    }
    public void doktorButton(View view){
        hideDefaultNavBar();
        hideAnimationsOnMainScreens();
        meslekSTR="Doktor";
        meslekInt=1;
        saveParts();
        sonkisimLY.setVisibility(View.INVISIBLE);
        lottiButtonsLY.setVisibility(View.VISIBLE);
        firstScreenisCompleted=true;
        karsilaTV.setVisibility(View.VISIBLE);
        setUserInterface();
    }
    public void muhendisButton(View view){
        hideDefaultNavBar();
        hideAnimationsOnMainScreens();
        meslekSTR="Mühendis";
        meslekInt=2;
        saveParts();
        sonkisimLY.setVisibility(View.INVISIBLE);
        lottiButtonsLY.setVisibility(View.VISIBLE);
        firstScreenisCompleted=true;
        karsilaTV.setVisibility(View.VISIBLE);
        setUserInterface();
    }
    public void isadamiButton(View view){
        hideDefaultNavBar();
        hideAnimationsOnMainScreens();
        meslekSTR="İş Adamı";
        meslekInt=3;
        saveParts();
        sonkisimLY.setVisibility(View.INVISIBLE);
        sonkisimLY.setVisibility(View.INVISIBLE);
        lottiButtonsLY.setVisibility(View.VISIBLE);
        firstScreenisCompleted=true;
        karsilaTV.setVisibility(View.VISIBLE);
        setUserInterface();
    }
    public void calisanButton(View view){
        hideDefaultNavBar();
        hideAnimationsOnMainScreens();
        meslekSTR="Emektar";
        meslekInt=4;
        saveParts();
        sonkisimLY.setVisibility(View.INVISIBLE);
        lottiButtonsLY.setVisibility(View.VISIBLE);
        firstScreenisCompleted=true;
        karsilaTV.setVisibility(View.VISIBLE);
        setUserInterface();
    }
    public void ogrenciButton(View view){
        hideDefaultNavBar();
        hideAnimationsOnMainScreens();
        meslekSTR="Öğrenci";
        meslekInt=5;
        saveParts();
        sonkisimLY.setVisibility(View.INVISIBLE);
        lottiButtonsLY.setVisibility(View.VISIBLE);
        firstScreenisCompleted=true;
        karsilaTV.setVisibility(View.VISIBLE);
        setUserInterface();
    }
    public void digerButton(View view){
        hideDefaultNavBar();
        hideAnimationsOnMainScreens();
        meslekSTR="Diğer";
        meslekInt=6;
        saveParts();
        sonkisimLY.setVisibility(View.INVISIBLE);
        lottiButtonsLY.setVisibility(View.VISIBLE);
        firstScreenisCompleted=true;
        karsilaTV.setVisibility(View.VISIBLE);
        setUserInterface();
    }
    public void hideAnimationsOnMainScreens(){
        hideDefaultNavBar();
        doktorkarsilamaLT.setVisibility(View.INVISIBLE);
        muhendisKarsilamaLT.setVisibility(View.INVISIBLE);
        isadamiKarsilamaLT.setVisibility(View.INVISIBLE);
        calisanKarsilamaLT.setVisibility(View.INVISIBLE);
        ogrenciKarsilamaLT.setVisibility(View.INVISIBLE);
        digerKarsilamaLT.setVisibility(View.INVISIBLE);
        doktorkarsilamaLT2.setVisibility(View.INVISIBLE);
        muhendisKarsilamaLT2.setVisibility(View.INVISIBLE);
        isadamiKarsilamaLT2.setVisibility(View.INVISIBLE);
        iskadinikarsilamaLT.setVisibility(View.INVISIBLE);
        iskadinikarsilamaLT2.setVisibility(View.INVISIBLE);
        calisanKarsilamaLT2.setVisibility(View.INVISIBLE);
        ogrenciKarsilamaLT2.setVisibility(View.INVISIBLE);
        digerKarsilamaLT2.setVisibility(View.INVISIBLE);
        digerKadinKarsilamaLT.setVisibility(View.INVISIBLE);
        digerKadinKarsilamaLT2.setVisibility(View.INVISIBLE);
    }
    public void hideAllFirstPart(){
        hideDefaultNavBar();
        doktorLT.setVisibility(View.INVISIBLE);
        muhendisLT.setVisibility(View.INVISIBLE);
        isadamiLT.setVisibility(View.INVISIBLE);
        calisanLT.setVisibility(View.INVISIBLE);
        ogrenciLT.setVisibility(View.INVISIBLE);
        digerLT.setVisibility(View.INVISIBLE);
        baslangicLY.setVisibility(View.INVISIBLE);
        ilkkisimLY.setVisibility(View.VISIBLE);
        ilkkisimLY.setVisibility(View.INVISIBLE);
        ilksoruTV.setVisibility(View.INVISIBLE);
        ikincikisimLY.setVisibility(View.INVISIBLE);
        sonkisimLY.setVisibility(View.INVISIBLE);
    }
    public void saveParts(){
        hideDefaultNavBar();
        cinsiyetSP.edit().putBoolean("cinsiyetKaydi",maleBool).apply();
        isimSP.edit().putString("isimKaydi",isimSTR).apply();
        meslekSP.edit().putString("meslekKaydi",meslekSTR).apply();
        isOkaySP.edit().putBoolean("isOkayKaydi",firstScreenisCompleted).apply();
    }
    public void getSaves(){
        hideDefaultNavBar();
        maleBool = cinsiyetSP.getBoolean("cinsiyetKaydi",true);
        isimSTR = isimSP.getString("isimKaydi",null);
        meslekSTR = meslekSP.getString("meslekKaydi",null);
        firstScreenisCompleted = isOkaySP.getBoolean("isOkayKaydi",false);
    }
    public void setUserInterface() {
        hideDefaultNavBar();
        if (meslekSTR.equals("Doktor")) {
            layoutDovizLY.setVisibility(View.INVISIBLE);
            layoutAltinLY.setVisibility(View.INVISIBLE);
            userInterfaceLY.setVisibility(View.VISIBLE);
            doktorLT.setVisibility(View.VISIBLE);
            isimSTR = isimSTR.toUpperCase();
            if (maleBool == true) {
                karsilaTV.setText("Merhaba Doktor Bey! Döviz Kurları Icin Sola Altın Kurları Icin Saga Gidebilirsin");
                dovizScreenKarsilamaTV.setText("Sayın Doktor " + isimSTR + " Bey Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
                altinScreenKarsilamaTV.setText("Sayın Doktor " + isimSTR + " Bey Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
            }
            if (maleBool == false) {
                karsilaTV.setText("Merhaba Doktor Hanım! Döviz Kurları Icin Sola Altın Kurları Icin Saga Gidebilirsin");
                dovizScreenKarsilamaTV.setText("Sayın Doktor " + isimSTR + " Hanım Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
                altinScreenKarsilamaTV.setText("Sayın Doktor " + isimSTR + " Hanım Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
            }
                doktorkarsilamaLT.setVisibility(View.VISIBLE);
                doktorkarsilamaLT2.setVisibility(View.VISIBLE);
                lottiButtonsLY.setVisibility(View.VISIBLE);

        }
        if (meslekSTR.equals("Mühendis")) {
            layoutDovizLY.setVisibility(View.INVISIBLE);
            layoutAltinLY.setVisibility(View.INVISIBLE);
            userInterfaceLY.setVisibility(View.VISIBLE);
            muhendisLT.setVisibility(View.VISIBLE);
            isimSTR = isimSTR.toUpperCase();
            if (maleBool == true) {
                karsilaTV.setText("Selam Mühendis Bey! Döviz Kurları Icin Sola Altın Kurları Icin Saga Gidebilirsin");
                dovizScreenKarsilamaTV.setText("Sayın Mühendis " + isimSTR + " Bey Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
                altinScreenKarsilamaTV.setText("Sayın Mühendis " + isimSTR + " Bey Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
            }
            if (maleBool == false) {
                karsilaTV.setText("Selam Mühendis Hanım! Döviz Kurları Icin Sola Altın Kurları Icin Saga Gidebilirsin");
                dovizScreenKarsilamaTV.setText("Sayın Mühendis " + isimSTR + " Hanım Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
                altinScreenKarsilamaTV.setText("Sayın Mühendis " + isimSTR + " Hanım Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
            }
            muhendisKarsilamaLT.setVisibility(View.VISIBLE);
            muhendisKarsilamaLT2.setVisibility(View.VISIBLE);
            lottiButtonsLY.setVisibility(View.VISIBLE);
        }
        if (meslekSTR.equals("İş Adamı")) {
            layoutDovizLY.setVisibility(View.INVISIBLE);
            layoutAltinLY.setVisibility(View.INVISIBLE);
            userInterfaceLY.setVisibility(View.VISIBLE);
            isadamiLT.setVisibility(View.VISIBLE);
            isimSTR = isimSTR.toUpperCase();
            if (maleBool == true) {
                iskadiniLT.setVisibility(View.INVISIBLE);
                isadamiLT.setVisibility(View.VISIBLE);
                iskadinikarsilamaLT.setVisibility(View.INVISIBLE);
                iskadinikarsilamaLT2.setVisibility(View.INVISIBLE);
                isadamiKarsilamaLT.setVisibility(View.VISIBLE);
                isadamiKarsilamaLT2.setVisibility(View.VISIBLE);
                karsilaTV.setText("Merhaba Patron! Döviz Kurları Icin Sola Altın Kurları Icin Saga Gidebilirsin");
                dovizScreenKarsilamaTV.setText("Sayın İş Adamı " + isimSTR + " Bey Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
                altinScreenKarsilamaTV.setText("Sayın İş Adamı " + isimSTR + " Bey Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
            }
            if (maleBool == false) {
                iskadiniLT.setVisibility(View.VISIBLE);
                isadamiLT.setVisibility(View.INVISIBLE);
                isadamiKarsilamaLT.setVisibility(View.INVISIBLE);
                isadamiKarsilamaLT2.setVisibility(View.INVISIBLE);
                iskadinikarsilamaLT.setVisibility(View.VISIBLE);
                iskadinikarsilamaLT2.setVisibility(View.VISIBLE);
                karsilaTV.setText("Merhaba Müdürüm! Döviz Kurları Icin Sola Altın Kurları Icin Saga Gidebilirsin");
                dovizScreenKarsilamaTV.setText("Sayın İş Kadını " + isimSTR + " Hanım Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
                altinScreenKarsilamaTV.setText("Sayın İş Kadını " + isimSTR + " Hanım Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
            }

            lottiButtonsLY.setVisibility(View.VISIBLE);
        }
        if (meslekSTR.equals("Emektar")) {
            layoutDovizLY.setVisibility(View.INVISIBLE);
            layoutAltinLY.setVisibility(View.INVISIBLE);
            userInterfaceLY.setVisibility(View.VISIBLE);
            calisanLT.setVisibility(View.VISIBLE);
            isimSTR = isimSTR.toUpperCase();
            if(maleBool==true) {
                karsilaTV.setText("Merhaba Emektar Bey! Döviz Kurları Icin Sola Altın Kurları Icin Saga Gidebilirsin");
                dovizScreenKarsilamaTV.setText("Sayın Emektar " + isimSTR + " Bey Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
                altinScreenKarsilamaTV.setText("Sayın Emektar " + isimSTR + " Bey Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
            }
            if(maleBool==false) {
                karsilaTV.setText("Merhaba Emektar Hanım! Döviz Kurları Icin Sola Altın Kurları Icin Saga Gidebilirsin");
                dovizScreenKarsilamaTV.setText("Sayın Emektar " + isimSTR + " Hanım Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
                altinScreenKarsilamaTV.setText("Sayın Emektar " + isimSTR + " Hanım Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
            }
            calisanKarsilamaLT.setVisibility(View.VISIBLE);
            calisanKarsilamaLT2.setVisibility(View.VISIBLE);
            lottiButtonsLY.setVisibility(View.VISIBLE);
        }
        if (meslekSTR.equals("Öğrenci")) {
            layoutDovizLY.setVisibility(View.INVISIBLE);
            layoutAltinLY.setVisibility(View.INVISIBLE);
            userInterfaceLY.setVisibility(View.VISIBLE);
            ogrenciLT.setVisibility(View.VISIBLE);
            isimSTR = isimSTR.toUpperCase();
            if(maleBool==true) {
                karsilaTV.setText("Merhaba Öğreci Dostum Döviz Kurları Icin Sola Altın Kurları Icin Saga Gidebilirsin");
                dovizScreenKarsilamaTV.setText("Öğrenci Dostum " + isimSTR + " Senin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsin");
                altinScreenKarsilamaTV.setText("Öğrenci Dostum " + isimSTR + " Senin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsin");
            }
            if(maleBool==false) {
                karsilaTV.setText("Merhaba Öğreci Arkadaşım Döviz Kurları Icin Sola Altın Kurları Icin Saga Gidebilirsin");
                dovizScreenKarsilamaTV.setText("Öğrenci Arkadaşım " + isimSTR + " Senin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsin");
                altinScreenKarsilamaTV.setText("Öğrenci Arkadaşım " + isimSTR + " Senin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsin");
            }
            ogrenciKarsilamaLT.setVisibility(View.VISIBLE);
            ogrenciKarsilamaLT2.setVisibility(View.VISIBLE);
            lottiButtonsLY.setVisibility(View.VISIBLE);
        }
        if (meslekSTR.equals("Diğer")) {
            layoutDovizLY.setVisibility(View.INVISIBLE);
            layoutAltinLY.setVisibility(View.INVISIBLE);
            userInterfaceLY.setVisibility(View.VISIBLE);
            digerLT.setVisibility(View.VISIBLE);
            isimSTR = isimSTR.toUpperCase();
            if(maleBool==true) {
                digerKadinLT.setVisibility(View.INVISIBLE);
                digerLT.setVisibility(View.VISIBLE);
                digerKadinKarsilamaLT.setVisibility(View.INVISIBLE);
                digerKadinKarsilamaLT2.setVisibility(View.INVISIBLE);
                digerKarsilamaLT.setVisibility(View.VISIBLE);
                digerKarsilamaLT2.setVisibility(View.VISIBLE);
                karsilaTV.setText("Merhaba! Döviz Kurları Icin Sola Altın Kurları Icin Saga Gidebilirsin");
                dovizScreenKarsilamaTV.setText("Sayın " + isimSTR + " Bey Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
                altinScreenKarsilamaTV.setText("Sayın " + isimSTR + " Bey Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
            }
            if(maleBool==false) {
                digerKadinLT.setVisibility(View.VISIBLE);
                digerLT.setVisibility(View.INVISIBLE);
                digerKarsilamaLT.setVisibility(View.INVISIBLE);
                digerKarsilamaLT2.setVisibility(View.INVISIBLE);
                digerKadinKarsilamaLT.setVisibility(View.VISIBLE);
                digerKadinKarsilamaLT2.setVisibility(View.VISIBLE);
                karsilaTV.setText("Merhaba! Döviz Kurları Icin Sola Altın Kurları Icin Saga Gidebilirsin");
                dovizScreenKarsilamaTV.setText("Sayın " + isimSTR + " Hanım Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
                altinScreenKarsilamaTV.setText("Sayın " + isimSTR + " Hanım Sizin İçin Bugünki Kurları Derledik. Aşağıdan Göz Atabilirsiniz");
            }
            lottiButtonsLY.setVisibility(View.VISIBLE);
        }
    }
    public void goSettings(View view) {
        hideDefaultNavBar();
        doktorLT.setVisibility(View.INVISIBLE);
        muhendisLT.setVisibility(View.INVISIBLE);
        isadamiLT.setVisibility(View.INVISIBLE);
        iskadiniLT.setVisibility(View.INVISIBLE);
        calisanLT.setVisibility(View.INVISIBLE);
        ogrenciLT.setVisibility(View.INVISIBLE);
        digerLT.setVisibility(View.INVISIBLE);
        digerKadinLT.setVisibility(View.INVISIBLE);
        layoutDovizLY.setVisibility(View.INVISIBLE);
        layoutAltinLY.setVisibility(View.INVISIBLE);
        isimaliciET.setText(null);
        hideAllFirstPart();
        baslangicLY.setVisibility(View.VISIBLE);
        karsilaTV.setVisibility(View.INVISIBLE);
        lottiButtonsLY.setVisibility(View.INVISIBLE);
    }
    public void goBottomDoviz(View view){
        hideDefaultNavBar();
        final ScrollView scrollview = ((ScrollView) findViewById(R.id.dovizScreenLayout));
        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }
    public void goBottomAltin(View view){
        hideDefaultNavBar();
        final ScrollView scrollview = ((ScrollView) findViewById(R.id.altinScreenLayout));
        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }
    public void rightArrowClicked(View view){
        hideDefaultNavBar();
        lottiButtonsLY.setVisibility(View.INVISIBLE);
        layoutAltinLY.setVisibility(View.VISIBLE);
    }
    public void leftArrowClicked(View view){
        hideDefaultNavBar();
        lottiButtonsLY.setVisibility(View.INVISIBLE);
        layoutDovizLY.setVisibility(View.VISIBLE);
    }
    public void hideDefaultNavBar(){
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
    public void createBottomMenu(){
        hideDefaultNavBar();
        //Menu İşlemleri
        final FlareBar bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setBarBackgroundColor(Color.parseColor("#D43357"));
        ArrayList<Flaretab> tabs = new ArrayList<>();
        tabs.add(new Flaretab(getResources().getDrawable(R.drawable.money),"Döviz Kurları","#189A5C"));
        tabs.add(new Flaretab(getResources().getDrawable(R.drawable.arrows),"Son Güncellenme"+sistemSaati,"#D43357"));
        tabs.add(new Flaretab(getResources().getDrawable(R.drawable.gold),"Altın Kurları","#F2F200"));
        bottomBar.setTabList(tabs);
        bottomBar.attachTabs(MainActivity.this);
        bottomBar.selectTab(1);

        //menuyu gizleme gösterme
        layoutDovizLY.getViewTreeObserver()
                .addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged() {
                        if (layoutDovizLY.getChildAt(0).getBottom()
                                <= (layoutDovizLY.getHeight() + layoutDovizLY.getScrollY())) {
                            bottomBar.hideBar();
                        } else {
                            bottomBar.showBar();
                        }
                    }
                });
        layoutAltinLY.getViewTreeObserver()
                .addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged() {
                        if (layoutAltinLY.getChildAt(0).getBottom()
                                <= (layoutAltinLY.getHeight() + layoutAltinLY.getScrollY())) {
                            bottomBar.hideBar();
                        } else {
                            bottomBar.showBar();
                        }
                    }
                });


        bottomBar.setTabChangedListener(new TabEventObject.TabChangedListener() {
            @Override
            public void onTabChanged(LinearLayout selectedTab, int selectedIndex, int oldIndex) {
                if(selectedIndex==0){
                    hideAllFirstPart();
                    showDoviz();
                }
                if(selectedIndex==1){
                    hideAllFirstPart();
                    refreshLT.playAnimation();
                    refresh2LT.playAnimation();
                    Toast.makeText(MainActivity.this,"Kurlar Güncel",Toast.LENGTH_SHORT).show();
                }
                if(selectedIndex==2){
                    hideAllFirstPart();
                    showAltin();
                }
            }
        });

    }
    public void createDate(){
        hideDefaultNavBar();
        Calendar mcurrentTime = Calendar.getInstance();//
        hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);//Güncel saati aldık
        minute = mcurrentTime.get(Calendar.MINUTE);//Güncel dakikayı aldık
        year = mcurrentTime.get(Calendar.YEAR);//Güncel Yılı alıyoruz
        month = mcurrentTime.get(Calendar.MONTH);//Güncel Ayı alıyoruz
        day = mcurrentTime.get(Calendar.DAY_OF_MONTH);//Güncel Günü alıyoruz
        sistemSaati="  "+hour+"."+minute+" ";
        sistemTarihi=" "+day+"."+month+"."+year+"";
        createBottomMenu();

    }
    public void getRates(View view){
        hideDefaultNavBar();
        DownloadData downloadData = new DownloadData();
        refreshLT.playAnimation();
        refresh2LT.playAnimation();
        Toast.makeText(MainActivity.this,"Kurlar Güncel",Toast.LENGTH_SHORT).show();
       createDate();

        try {
            String url = "https://finans.truncgil.com/today.json";
            downloadData.execute(url);

        }catch (Exception e){
        }
    }
    public void showDoviz() {
        hideDefaultNavBar();
        layoutAltinLY.setVisibility(View.INVISIBLE);
        layoutDovizLY.setVisibility(View.VISIBLE);
    }
    public void showAltin() {
        hideDefaultNavBar();
        layoutDovizLY.setVisibility(View.INVISIBLE);
        layoutAltinLY.setVisibility(View.VISIBLE);
    }
    private class DownloadData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            String result = "" ;
            URL url ;
            HttpsURLConnection httpsURLConnection ;

            try{

                url = new URL(strings[0]) ;
                httpsURLConnection = (HttpsURLConnection) url.openConnection();
                InputStream inputStream = httpsURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();
                int i = 1 ;


                while (data > 0){

                    char character = (char) data ;

                    result += character ;
                    data = inputStreamReader.read();


                }

                return result ;

            }catch (Exception e){
                System.out.println("Bağlantınız Yavaş");
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //dovizKurlarınıÇekme
            try{

                JSONObject tarih_json = new JSONObject(s) ;
                String Tarih = tarih_json.getString("Güncelleme Tarihi");


                JSONObject abd_dolllar_json = new JSONObject(s) ;
                String abd_dolar_string = abd_dolllar_json.getString("ABD DOLARI");

                if (abd_dolar_string.contains(",")){
                    abd_dolar_string = abd_dolar_string.replaceAll(",", "     ");
                    abd_dolar_string = abd_dolar_string.replaceAll("Tür", "");
                    abd_dolar_string = abd_dolar_string.replaceAll("Döviz", "");
                    abd_dolar_string = abd_dolar_string.replaceAll(":", "");
                    abd_dolar_string = abd_dolar_string.replace('"',' ');
                    abd_dolar_string = abd_dolar_string.replace('{',' ');
                    abd_dolar_string = abd_dolar_string.replace('}',' ');
                }
                abd_dollar.setText(abd_dolar_string);


                JSONObject au_dollar_json = new JSONObject(s) ;
                String au_dollar_string = au_dollar_json.getString("AVUSTRALYA DOLARI");
                if (au_dollar_string.contains(",")) {
                    au_dollar_string = au_dollar_string.replaceAll(",", "     ");
                    au_dollar_string = au_dollar_string.replaceAll("Tür", "");
                    au_dollar_string = au_dollar_string.replaceAll("Döviz", "");
                    au_dollar_string = au_dollar_string.replaceAll(":", "");
                    au_dollar_string = au_dollar_string.replace('"',' ');
                    au_dollar_string = au_dollar_string.replace('{',' ');
                    au_dollar_string = au_dollar_string.replace('}',' ');
                }
                au_dollar.setText(au_dollar_string);


                JSONObject euro_json = new JSONObject(s) ;
                String euro_string = euro_json.getString("EURO");
                if (euro_string.contains(",")) {
                    euro_string = euro_string.replaceAll(",", "     ");
                    euro_string = euro_string.replaceAll("Tür", "");
                    euro_string = euro_string.replaceAll("Döviz", "");
                    euro_string = euro_string.replaceAll(":", "");
                    euro_string = euro_string.replace('"',' ');
                    euro_string = euro_string.replace('{',' ');
                    euro_string = euro_string.replace('}',' ');
                }
                euro.setText(euro_string);


                JSONObject sterlin_json = new JSONObject(s) ;
                String sterlin_string = sterlin_json.getString("İNGİLİZ STERLİNİ");
                if (sterlin_string.contains(",")) {
                    sterlin_string = sterlin_string.replaceAll(",", "     ");
                    sterlin_string = sterlin_string.replaceAll("Tür", "");
                    sterlin_string = sterlin_string.replaceAll("Döviz", "");
                    sterlin_string = sterlin_string.replaceAll(":", "");
                    sterlin_string = sterlin_string.replace('"',' ');
                    sterlin_string = sterlin_string.replace('{',' ');
                    sterlin_string = sterlin_string.replace('}',' ');
                }
                sterlin.setText(sterlin_string);


                JSONObject frang_json = new JSONObject(s) ;
                String frang_string = frang_json.getString("İSVİÇRE FRANGI");
                if (frang_string.contains(",")) {
                    frang_string = frang_string.replaceAll(",", "     ");
                    frang_string = frang_string.replaceAll("Tür", "");
                    frang_string = frang_string.replaceAll("Döviz", "");
                    frang_string = frang_string.replaceAll(":", "");
                    frang_string = frang_string.replace('"',' ');
                    frang_string = frang_string.replace('{',' ');
                    frang_string = frang_string.replace('}',' ');
                }
                frang.setText(frang_string);


                JSONObject yuan_json = new JSONObject(s) ;
                String yuan_string = yuan_json.getString("ÇİN YUANI");
                if (yuan_string.contains(",")) {
                    yuan_string = yuan_string.replaceAll(",", "     ");
                    yuan_string = yuan_string.replaceAll("Tür", "");
                    yuan_string = yuan_string.replaceAll("Döviz", "");
                    yuan_string = yuan_string.replaceAll(":", "");
                    yuan_string = yuan_string.replace('"',' ');
                    yuan_string = yuan_string.replace('{',' ');
                    yuan_string = yuan_string.replace('}',' ');
                }
                yuan.setText(yuan_string);


                JSONObject yen_json = new JSONObject(s) ;
                String yen_string = yen_json.getString("JAPON YENİ");
                if (yen_string.contains(",")) {
                    yen_string = yen_string.replaceAll(",", "     ");
                    yen_string = yen_string.replaceAll("Tür", "");
                    yen_string = yen_string.replaceAll("Döviz", "");
                    yen_string = yen_string.replaceAll(":", "");
                    yen_string = yen_string.replace('"',' ');
                    yen_string = yen_string.replace('{',' ');
                    yen_string = yen_string.replace('}',' ');
                }
                yen.setText(yen_string);


                JSONObject dan_kron_json = new JSONObject(s) ;
                String dan_kron_string = dan_kron_json.getString("DANİMARKA KRONU");
                if (dan_kron_string.contains(",")) {
                    dan_kron_string = dan_kron_string.replaceAll(",", "     ");
                    dan_kron_string = dan_kron_string.replaceAll("Tür", "");
                    dan_kron_string = dan_kron_string.replaceAll("Döviz", "");
                    dan_kron_string = dan_kron_string.replaceAll(":", "");
                    dan_kron_string = dan_kron_string.replace('"',' ');
                    dan_kron_string = dan_kron_string.replace('{',' ');
                    dan_kron_string = dan_kron_string.replace('}',' ');
                }
                dan_kron.setText(dan_kron_string);


                JSONObject dinar_json = new JSONObject(s) ;
                String dinar_string = dinar_json.getString("KUVEYT DİNARI");
                if (dinar_string.contains(",")) {
                    dinar_string = dinar_string.replaceAll(",", "     ");
                    dinar_string = dinar_string.replaceAll("Tür", "");
                    dinar_string = dinar_string.replaceAll("Döviz", "");
                    dinar_string = dinar_string.replaceAll(":", "");
                    dinar_string = dinar_string.replace('"',' ');
                    dinar_string = dinar_string.replace('{',' ');
                    dinar_string = dinar_string.replace('}',' ');
                }
                kuvety_dinar.setText(dinar_string);


                JSONObject ruble_json = new JSONObject(s) ;
                String ruble_string = ruble_json.getString("RUS RUBLESİ");
                if (ruble_string.contains(",")) {
                    ruble_string = ruble_string.replaceAll(",", "     ");
                    ruble_string = ruble_string.replaceAll("Tür", "");
                    ruble_string = ruble_string.replaceAll("Döviz", "");
                    ruble_string = ruble_string.replaceAll(":", "");
                    ruble_string = ruble_string.replace('"',' ');
                    ruble_string = ruble_string.replace('{',' ');
                    ruble_string = ruble_string.replace('}',' ');
                }
                ruble.setText(ruble_string);


                JSONObject suudi_riyal_json = new JSONObject(s) ;
                String suudi_riyal_string = suudi_riyal_json.getString("SUUDİ ARABİSTAN RİYALİ");
                if (suudi_riyal_string.contains(",")) {
                    suudi_riyal_string = suudi_riyal_string.replaceAll(",", "     ");
                    suudi_riyal_string = suudi_riyal_string.replaceAll("Tür", "");
                    suudi_riyal_string = suudi_riyal_string.replaceAll("Döviz", "");
                    suudi_riyal_string = suudi_riyal_string.replaceAll(":", "");
                    suudi_riyal_string = suudi_riyal_string.replace('"',' ');
                    suudi_riyal_string = suudi_riyal_string.replace('{',' ');
                    suudi_riyal_string = suudi_riyal_string.replace('}',' ');
                }
                suudi_riyal.setText(suudi_riyal_string);


                JSONObject isvicre_kron_json = new JSONObject(s) ;
                String isvicre_kron_string = isvicre_kron_json.getString("İSVEÇ KRONU");
                if (isvicre_kron_string.contains(",")) {
                    isvicre_kron_string = isvicre_kron_string.replaceAll(",", "     ");
                    isvicre_kron_string = isvicre_kron_string.replaceAll("Tür", "");
                    isvicre_kron_string = isvicre_kron_string.replaceAll("Döviz", "");
                    isvicre_kron_string = isvicre_kron_string.replaceAll(":", "");
                    isvicre_kron_string = isvicre_kron_string.replace('"',' ');
                    isvicre_kron_string = isvicre_kron_string.replace('{',' ');
                    isvicre_kron_string = isvicre_kron_string.replace('}',' ');
                }
                isvicre_kron.setText(isvicre_kron_string);


                JSONObject cad_dollar_json = new JSONObject(s) ;
                String cad_dollar_string = cad_dollar_json.getString("KANADA DOLARI");
                if (cad_dollar_string.contains(",")) {
                    cad_dollar_string = cad_dollar_string.replaceAll(",", "     ");
                    cad_dollar_string = cad_dollar_string.replaceAll("Tür", "");
                    cad_dollar_string = cad_dollar_string.replaceAll("Döviz", "");
                    cad_dollar_string = cad_dollar_string.replaceAll(":", "");
                    cad_dollar_string = cad_dollar_string.replace('"',' ');
                    cad_dollar_string = cad_dollar_string.replace('{',' ');
                    cad_dollar_string = cad_dollar_string.replace('}',' ');
                }
                cad_dollar.setText(cad_dollar_string);


                JSONObject katar_riyal_json = new JSONObject(s) ;
                String katar_riyal_string = katar_riyal_json.getString("KATAR RİYALİ");
                if (katar_riyal_string.contains(",")) {
                    katar_riyal_string = katar_riyal_string.replaceAll(",", "     ");
                    katar_riyal_string = katar_riyal_string.replaceAll("Tür", "");
                    katar_riyal_string = katar_riyal_string.replaceAll("Döviz", "");
                    katar_riyal_string = katar_riyal_string.replaceAll(":", "");
                    katar_riyal_string = katar_riyal_string.replace('"',' ');
                    katar_riyal_string = katar_riyal_string.replace('{',' ');
                    katar_riyal_string = katar_riyal_string.replace('}',' ');
                }
                katar_riyal.setText(katar_riyal_string);


                JSONObject iran_riyal_json = new JSONObject(s) ;
                String iran_riyal_string = iran_riyal_json.getString("İRAN RİYALİ");
                if (iran_riyal_string.contains(",")) {
                    iran_riyal_string = iran_riyal_string.replaceAll(",", "     ");
                    iran_riyal_string = iran_riyal_string.replaceAll("Tür", "");
                    iran_riyal_string = iran_riyal_string.replaceAll("Döviz", "");
                    iran_riyal_string = iran_riyal_string.replaceAll(":", "");
                    iran_riyal_string = iran_riyal_string.replace('"',' ');
                    iran_riyal_string = iran_riyal_string.replace('{',' ');
                    iran_riyal_string = iran_riyal_string.replace('}',' ');
                }
                iran_riyal.setText(iran_riyal_string);


                JSONObject leva_json = new JSONObject(s) ;
                String leva_string = leva_json.getString("BULGAR LEVASI");
                if (leva_string.contains(",")) {
                    leva_string = leva_string.replaceAll(",", "     ");
                    leva_string = leva_string.replaceAll("Tür", "");
                    leva_string = leva_string.replaceAll("Döviz", "");
                    leva_string = leva_string.replaceAll(":", "");
                    leva_string = leva_string.replace('"',' ');
                    leva_string = leva_string.replace('{',' ');
                    leva_string = leva_string.replace('}',' ');
                }
                bulgar_leva.setText(leva_string);


                JSONObject norvec_kron_json = new JSONObject(s) ;
                String norvec_kron_string = norvec_kron_json.getString("NORVEÇ KRONU");
                if (norvec_kron_string.contains(",")) {
                    norvec_kron_string = norvec_kron_string.replaceAll(",", "     ");
                    norvec_kron_string = norvec_kron_string.replaceAll("Tür", "");
                    norvec_kron_string = norvec_kron_string.replaceAll("Döviz", "");
                    norvec_kron_string = norvec_kron_string.replaceAll(":", "");
                    norvec_kron_string = norvec_kron_string.replace('"',' ');
                    norvec_kron_string = norvec_kron_string.replace('{',' ');
                    norvec_kron_string = norvec_kron_string.replace('}',' ');
                }
                norvec_kron.setText(norvec_kron_string);


                JSONObject pakistan_json = new JSONObject(s) ;
                String pakistan_string = pakistan_json.getString("PAKİSTAN RUPİSİ");
                if (pakistan_string.contains(",")) {
                    pakistan_string = pakistan_string.replaceAll(",", "     ");
                    pakistan_string = pakistan_string.replaceAll("Tür", "");
                    pakistan_string = pakistan_string.replaceAll("Döviz", "");
                    pakistan_string = pakistan_string.replaceAll(":", "");
                    pakistan_string = pakistan_string.replace('"',' ');
                    pakistan_string = pakistan_string.replace('{',' ');
                    pakistan_string = pakistan_string.replace('}',' ');
                }
                pakistan_rupi.setText(pakistan_string);



                JSONObject gram_atin_json = new JSONObject(s) ;
                String gram_atin_string = gram_atin_json.getString("Gram Altın");
                if (gram_atin_string.contains(",")){
                    gram_atin_string = gram_atin_string.replaceAll(",", ", ");
                    gram_atin_string = gram_atin_string.replaceAll("Tür", "");
                    gram_atin_string = gram_atin_string.replaceAll("Altın", "");
                    gram_atin_string = gram_atin_string.replaceAll(":", "");
                    gram_atin_string = gram_atin_string.replace('"',' ');
                    gram_atin_string = gram_atin_string.replace('{',' ');
                    gram_atin_string = gram_atin_string.replace('}',' ');
                }
                gram_altin.setText(gram_atin_string);


                JSONObject ceyrek_atin_json = new JSONObject(s) ;
                String ceyrek_atin_string = ceyrek_atin_json.getString("Çeyrek Altın");
                if (ceyrek_atin_string.contains(",")){
                    ceyrek_atin_string = ceyrek_atin_string.replaceAll(",", " ");
                    ceyrek_atin_string = ceyrek_atin_string.replaceAll("Tür", "");
                    ceyrek_atin_string = ceyrek_atin_string.replaceAll("Altın", "");
                    ceyrek_atin_string = ceyrek_atin_string.replaceAll(":", "");
                    ceyrek_atin_string = ceyrek_atin_string.replace('"',' ');
                    ceyrek_atin_string = ceyrek_atin_string.replace('{',' ');
                    ceyrek_atin_string = ceyrek_atin_string.replace('}',' ');
                }
                ceyrek_altin.setText(ceyrek_atin_string);


                JSONObject yarim_atin_json = new JSONObject(s) ;
                String yarim_atin_string = yarim_atin_json.getString("Yarım Altın");
                if (yarim_atin_string.contains(",")){
                    yarim_atin_string = yarim_atin_string.replaceAll("Tür", "");
                    yarim_atin_string = yarim_atin_string.replaceAll("Altın", "");
                    yarim_atin_string = yarim_atin_string.replaceAll(":", "");
                    yarim_atin_string = yarim_atin_string.replace('"',' ');
                    yarim_atin_string = yarim_atin_string.replace('{',' ');
                    yarim_atin_string = yarim_atin_string.replace('}',' ');
                }
                yarim_altin.setText(yarim_atin_string);


                JSONObject tam_atin_json = new JSONObject(s) ;
                String tam_atin_string = tam_atin_json.getString("Tam Altın");
                if (tam_atin_string.contains(",")){
                    tam_atin_string = tam_atin_string.replaceAll(",", "");
                    tam_atin_string = tam_atin_string.replaceAll("Tür", "");
                    tam_atin_string = tam_atin_string.replaceAll("Altın", "");
                    tam_atin_string = tam_atin_string.replaceAll(":", "");
                    tam_atin_string = tam_atin_string.replace('"',' ');
                    tam_atin_string = tam_atin_string.replace('{',' ');
                    tam_atin_string = tam_atin_string.replace('}',' ');
                }
                tam_altin.setText(tam_atin_string);


                JSONObject ons_atin_json = new JSONObject(s) ;
                String ons_atin_string = ons_atin_json.getString("Ons Altın");
                if (ons_atin_string.contains(",")){
                    ons_atin_string = ons_atin_string.replaceAll(",", "");
                    ons_atin_string = ons_atin_string.replaceAll("Tür", "");
                    ons_atin_string = ons_atin_string.replaceAll("Altın", "");
                    ons_atin_string = ons_atin_string.replaceAll(":", "");
                    ons_atin_string = ons_atin_string.replace('"',' ');
                    ons_atin_string = ons_atin_string.replace('{',' ');
                    ons_atin_string = ons_atin_string.replace('}',' ');
                }
                ons_altin.setText(ons_atin_string);


                JSONObject cmhr_atin_json = new JSONObject(s) ;
                String cmhr_atin_string = cmhr_atin_json.getString("Cumhuriyet Altını");
                if (cmhr_atin_string.contains(",")){
                    cmhr_atin_string = cmhr_atin_string.replaceAll(",", "");
                    cmhr_atin_string = cmhr_atin_string.replaceAll("Tür", "");
                    cmhr_atin_string = cmhr_atin_string.replaceAll("Altın", "");
                    cmhr_atin_string = cmhr_atin_string.replaceAll(":", "");
                    cmhr_atin_string = cmhr_atin_string.replace('"',' ');
                    cmhr_atin_string = cmhr_atin_string.replace('{',' ');
                    cmhr_atin_string = cmhr_atin_string.replace('}',' ');
                }
                cmhr_altin.setText(cmhr_atin_string);

                JSONObject ondort_atin_json = new JSONObject(s) ;
                String ondort_atin_string = ondort_atin_json.getString("14 Ayar Altın");
                if (ondort_atin_string.contains(",")){
                    ondort_atin_string = ondort_atin_string.replaceAll(",", " ");
                    ondort_atin_string = ondort_atin_string.replaceAll("Tür", "");
                    ondort_atin_string = ondort_atin_string.replaceAll("Altın", "");
                    ondort_atin_string = ondort_atin_string.replaceAll(":", "");
                    ondort_atin_string = ondort_atin_string.replace('"',' ');
                    ondort_atin_string = ondort_atin_string.replace('{',' ');
                    ondort_atin_string = ondort_atin_string.replace('}',' ');
                }
                ondort_altin.setText(ondort_atin_string);


                JSONObject onsekiz_atin_json = new JSONObject(s) ;
                String onsekiz_atin_string = onsekiz_atin_json.getString("18 Ayar Altın");
                if (onsekiz_atin_string.contains(",")){
                    onsekiz_atin_string = onsekiz_atin_string.replaceAll(",", " ");
                    onsekiz_atin_string = onsekiz_atin_string.replaceAll("Tür", "");
                    onsekiz_atin_string = onsekiz_atin_string.replaceAll("Altın", "");
                    onsekiz_atin_string = onsekiz_atin_string.replaceAll(":", "");
                    onsekiz_atin_string = onsekiz_atin_string.replace('"',' ');
                    onsekiz_atin_string = onsekiz_atin_string.replace('{',' ');
                    onsekiz_atin_string = onsekiz_atin_string.replace('}',' ');
                }
                onsekiz_altin.setText(onsekiz_atin_string);


                JSONObject yirmiiki_atin_json = new JSONObject(s) ;
                String yirmiiki_atin_string = yirmiiki_atin_json.getString("22 Ayar Bilezik");
                if (yirmiiki_atin_string.contains(",")){
                    yirmiiki_atin_string = yirmiiki_atin_string.replaceAll(",", " ");
                    yirmiiki_atin_string = yirmiiki_atin_string.replaceAll("Tür", "");
                    yirmiiki_atin_string = yirmiiki_atin_string.replaceAll("Altın", "");
                    yirmiiki_atin_string = yirmiiki_atin_string.replaceAll(":", "");
                    yirmiiki_atin_string = yirmiiki_atin_string.replace('"',' ');
                    yirmiiki_atin_string = yirmiiki_atin_string.replace('{',' ');
                    yirmiiki_atin_string = yirmiiki_atin_string.replace('}',' ');
                }
                yirmiiki_bilezik.setText(yirmiiki_atin_string);


                JSONObject resat_atin_json = new JSONObject(s) ;
                String resat_atin_string = resat_atin_json.getString("Reşat Altın");
                if (resat_atin_string.contains(",")){
                    resat_atin_string = resat_atin_string.replaceAll(",", "");
                    resat_atin_string = resat_atin_string.replaceAll("Tür", "");
                    resat_atin_string = resat_atin_string.replaceAll("Altın", "");
                    resat_atin_string = resat_atin_string.replaceAll(":", "");
                    resat_atin_string = resat_atin_string.replace('"',' ');
                    resat_atin_string = resat_atin_string.replace('{',' ');
                    resat_atin_string = resat_atin_string.replace('}',' ');
                }
                resat_altin.setText(resat_atin_string);


                JSONObject hamit_atin_json = new JSONObject(s) ;
                String hamit_atin_string = hamit_atin_json.getString("Hamit Altın");
                if (hamit_atin_string.contains(",")){
                    hamit_atin_string = hamit_atin_string.replaceAll(",", "");
                    hamit_atin_string = hamit_atin_string.replaceAll("Tür", "");
                    hamit_atin_string = hamit_atin_string.replaceAll("Altın", "");
                    hamit_atin_string = hamit_atin_string.replaceAll(":", "");
                    hamit_atin_string = hamit_atin_string.replace('"',' ');
                    hamit_atin_string = hamit_atin_string.replace('{',' ');
                    hamit_atin_string = hamit_atin_string.replace('}',' ');
                }
                hamit_altin.setText(hamit_atin_string);


                JSONObject ikibucuk_atin_json = new JSONObject(s) ;
                String ikibucuk_atin_string = ikibucuk_atin_json.getString("İkibuçuk Altın");
                if (ikibucuk_atin_string.contains(",")){
                    ikibucuk_atin_string = ikibucuk_atin_string.replaceAll(",", "");
                    ikibucuk_atin_string = ikibucuk_atin_string.replaceAll("Tür", "");
                    ikibucuk_atin_string = ikibucuk_atin_string.replaceAll("Altın", "");
                    ikibucuk_atin_string = ikibucuk_atin_string.replaceAll(":", "");
                    ikibucuk_atin_string = ikibucuk_atin_string.replace('"',' ');
                    ikibucuk_atin_string = ikibucuk_atin_string.replace('{',' ');
                    ikibucuk_atin_string = ikibucuk_atin_string.replace('}',' ');
                }
                ikibucuk_altin.setText(ikibucuk_atin_string);


                JSONObject besli_atin_json = new JSONObject(s) ;
                String besli_atin_string = besli_atin_json.getString("Beşli Altın");
                if (besli_atin_string.contains(",")){
                    besli_atin_string = besli_atin_string.replaceAll(",", "");
                    besli_atin_string = besli_atin_string.replaceAll("Tür", "");
                    besli_atin_string = besli_atin_string.replaceAll("Altın", "");
                    besli_atin_string = besli_atin_string.replaceAll(":", "");
                    besli_atin_string = besli_atin_string.replace('"',' ');
                    besli_atin_string = besli_atin_string.replace('{',' ');
                    besli_atin_string = besli_atin_string.replace('}',' ');
                }
                besli_altin.setText(besli_atin_string);


                JSONObject ata_atin_json = new JSONObject(s) ;
                String ata_atin_string = ata_atin_json.getString("Ata Altın");
                if (ata_atin_string.contains(",")){
                    ata_atin_string = ata_atin_string.replaceAll(",", " ");
                    ata_atin_string = ata_atin_string.replaceAll("Tür", "");
                    ata_atin_string = ata_atin_string.replaceAll("Altın", "");
                    ata_atin_string = ata_atin_string.replaceAll(":", "");
                    ata_atin_string = ata_atin_string.replace('"',' ');
                    ata_atin_string = ata_atin_string.replace('{',' ');
                    ata_atin_string = ata_atin_string.replace('}',' ');
                }
                ata_altin.setText(ata_atin_string);


                JSONObject gremse_atin_json = new JSONObject(s) ;
                String gremse_atin_string = gremse_atin_json.getString("Gremse Altın");
                if (gremse_atin_string.contains(",")){
                    gremse_atin_string = gremse_atin_string.replaceAll(",", " ");
                    gremse_atin_string = gremse_atin_string.replaceAll("Tür", "");
                    gremse_atin_string = gremse_atin_string.replaceAll("Altın", "");
                    gremse_atin_string = gremse_atin_string.replaceAll(":", "");
                    gremse_atin_string = gremse_atin_string.replace('"',' ');
                    gremse_atin_string = gremse_atin_string.replace('{',' ');
                    gremse_atin_string = gremse_atin_string.replace('}',' ');
                }
                gremse_altin.setText(gremse_atin_string);


                JSONObject gumus_json = new JSONObject(s) ;
                String gumus_string = gumus_json.getString("Gümüş");
                if (gumus_string.contains(",")){
                    gumus_string = gumus_string.replaceAll(",", " ");
                    gumus_string = gumus_string.replaceAll("Tür", "");
                    gumus_string = gumus_string.replaceAll("Altın", "");
                    gumus_string = gumus_string.replaceAll(":", "");
                    gumus_string = gumus_string.replace('"',' ');
                    gumus_string = gumus_string.replace('{',' ');
                    gumus_string = gumus_string.replace('}',' ');
                }
                gumus.setText(gumus_string);








            }catch (Exception e){

            }


        }



    }

}









