package com.ak.planner;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class MainActivity extends AppCompatActivity {

    private BottomSheetDialog mBottomSheetDialog;
    private View sheetView;
    public static final String url = "http://185.102.122.218:8080/emoji/";

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mActionBarToolbar);

        this.setTitle("Emobook");



        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                mBottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                sheetView = getLayoutInflater().inflate(R.layout.bottom_dialog_contextmenu, null);
                mBottomSheetDialog.setContentView(sheetView);
                mBottomSheetDialog.show();
                //Toast.makeText(getApplicationContext(), "gfhgf", Toast.LENGTH_SHORT).show();
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                builder
                        .addInterceptor(interceptor)
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS);

                final OkHttpClient client = builder.build();
                Service service = new Service() {
                    @Override
                    public Call<ResponseBody> get(String url) {
                        return null;
                    }

                };

                service = new Retrofit.Builder().baseUrl(url).client(client).build().create(MainActivity.Service.class);
                final Service finalService = service;

                ImageView angry = sheetView.findViewById(R.id.image_angry);
                angry.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Call<okhttp3.ResponseBody> req = finalService.get("0");

                        req.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                String res = null;
                                try {
                                    assert response.body() != null;
                                    res = response.body().string();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Toast.makeText(getApplicationContext(),res+"",Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Log.d("ERROR", t.getMessage());
                            }
                        });
                    }
                });
                ImageView surprise = sheetView.findViewById(R.id.image_surprise);
                surprise.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Call<okhttp3.ResponseBody> req = finalService.get("1");

                        req.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                String res = null;
                                try {
                                    assert response.body() != null;
                                    res = response.body().string();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Toast.makeText(getApplicationContext(),res+"",Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Log.d("ERROR", t.getMessage());
                            }
                        });
                    }
                });
                ImageView love = sheetView.findViewById(R.id.image_love);
                love.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Call<okhttp3.ResponseBody> req = finalService.get("2");

                        req.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                String res = null;
                                try {
                                    assert response.body() != null;
                                    res = response.body().string();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Toast.makeText(getApplicationContext(),res+"",Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Log.d("ERROR", t.getMessage());
                            }
                        });
                    }
                });
                ImageView joy = sheetView.findViewById(R.id.image_joy);
                joy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Call<okhttp3.ResponseBody> req = finalService.get("3");

                        req.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                String res = null;
                                try {
                                    assert response.body() != null;
                                    res = response.body().string();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Toast.makeText(getApplicationContext(),res+"",Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Log.d("ERROR", t.getMessage());
                            }
                        });
                    }
                });
                ImageView fear = sheetView.findViewById(R.id.image_fear);
                fear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Call<okhttp3.ResponseBody> req = finalService.get("4");

                        req.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                String res = null;
                                try {
                                    assert response.body() != null;
                                    res = response.body().string();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Toast.makeText(getApplicationContext(),res+"",Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Log.d("ERROR", t.getMessage());
                            }
                        });
                    }
                });
                ImageView sad = sheetView.findViewById(R.id.image_sad);
                sad.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Call<okhttp3.ResponseBody> req = finalService.get("5");

                        req.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                String res = null;
                                try {
                                    assert response.body() != null;
                                    res = response.body().string();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Toast.makeText(getApplicationContext(),res+"",Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Log.d("ERROR", t.getMessage());
                            }
                        });
                    }
                });

            }
        });

    }
    interface Service {
        @GET
        Call<ResponseBody> get(@Url String url);
    }




}