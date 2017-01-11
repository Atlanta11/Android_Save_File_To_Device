package enterprise.sample.com.android_save_file_to_device;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    
    private final String fileName = "note.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                getExternalStorageDirectory();
            }
        });


        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                getExternalStoragePublicDirectory();
            }
        });




    }


    private void writeFile() {

        File extStore = Environment.getExternalStorageDirectory();
        // ==> /storage/emulated/0/note.txt
        String path = extStore.getAbsolutePath() + "/" + fileName;
        Log.i("ExternalStorageDemo", "Save to: " + path);

        String data = "text";

        try {
            File myFile = new File(path);
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(data);  //
            myOutWriter.append('\n');
            myOutWriter.close();
            fOut.close();

            Toast.makeText(getApplicationContext(), fileName + " saved", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getExternalStorageDirectory(){

        Bitmap bitmap;
        OutputStream output;

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_android);
        File filepath = Environment.getExternalStorageDirectory();
        File dir = new File(filepath.getAbsolutePath() + "/Save Image Example");
        dir.mkdirs();

        File file = new File(dir, "myimage.png");

        Toast.makeText(MainActivity.this, filepath.getAbsolutePath() + "/Save Image Example/myimage.png", Toast.LENGTH_LONG).show();

        try {
            output = new FileOutputStream(file);

            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
            output.flush();
            output.close();

        }catch(Exception e) {
            e.printStackTrace();
        }


    }

    private void getExternalStoragePublicDirectory(){

        Bitmap bitmap;
        OutputStream output;

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_android);
        File filepath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File dir = new File(filepath.getAbsolutePath() + "/Save Image Example");
        dir.mkdirs();

        File file = new File(dir, "myimage.png");

        Toast.makeText(MainActivity.this, filepath.getAbsolutePath() + "/Save Image Example/myimage.png", Toast.LENGTH_LONG).show();

        try {
            output = new FileOutputStream(file);

            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
            output.flush();
            output.close();

        }catch(Exception e) {
            e.printStackTrace();
        }


    }


}
