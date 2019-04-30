package studio.tay.reporting.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.myhexaville.smartimagepicker.ImagePicker;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import studio.tay.reporting.R;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.helper.PrefManager;
import studio.tay.reporting.model.Support;
import studio.tay.reporting.presenter.QuestionPresenter;
import studio.tay.reporting.view.QuestionView;

public class AddQuestionActivity extends BaseActivity implements QuestionView {

    @BindView(R.id.cardQ)
    CardView cardQ;

    @BindView(R.id.edQuestion)
    EditText edQuestion;

    @BindView(R.id.btnSend)
    Button btnSend;

    QuestionPresenter presenter;

    @BindView(R.id.select_image_profile)
    LinearLayout selectImage;

    @BindView(R.id.image_object)
    ImageView imageObject;
    @BindView(R.id.noimage_profile)
    ImageView noImage;
    @BindView(R.id.tv_take)
    TextView tvTake;

    private static int RESULT_LOAD_IMAGE = 1;
    File file = null;
    String picturepath = null;

    ImagePicker imagePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolba);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        presenter = new QuestionPresenter(this);
        cardQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edQuestion.findFocus();
            }
        });
        verifyStoragePermissions(this);
        final PrefManager prefManager = new PrefManager(this);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edQuestion.getText().toString().equals(" ") || edQuestion.getText() == null)
                {
                    Toast.makeText(AddQuestionActivity.this, "Tulis Pertanyaan Telebih dahulu", Toast.LENGTH_SHORT).show();
                }else{
                    presenter.sendquestion(String.valueOf(prefManager.getUserId()),edQuestion.getText().toString(),picturepath);
                }
            }
        });

        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            picturepath = picturePath;
            cursor.close();

            imageObject.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            imageObject.setVisibility(View.VISIBLE);
            noImage.setVisibility(View.GONE);
            tvTake.setVisibility(View.GONE);

        }


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onSuccessSendQuestion(String status) {
        startActivity(new Intent(getApplicationContext(),SupportActivity.class));
        Toast.makeText(this, "Pertanyaan anda sudah di kirim", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessLoadQuestions(List<Support> supports) {

    }

    @Override
    public void onShow() {
        super.showLoading();
    }

    @Override
    public void onHide() {
        super.dismissLoading();
    }

    @Override
    public void onError(String error) {
        super.showError(error);
    }

    @Override
    public void getHttp(String http) {
        super.showHttp(http);
    }
}
