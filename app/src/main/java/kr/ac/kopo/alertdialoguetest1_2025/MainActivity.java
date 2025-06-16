package kr.ac.kopo.alertdialoguetest1_2025;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn1 = findViewById(R.id.btn1);
        ImageView imgv = findViewById(R.id.imgv);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] hollweenIcons={"해골","좀비","박쥐","검은 고양이"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("인공지능소프트웨어과 공지사항");
                dlg.setItems(hollweenIcons, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn1.setText(hollweenIcons[which]);
                        switch (which){
                            case 0:
                                imgv.setImageResource(R.drawable.skull);
                                break;
                            case 1:
                                imgv.setImageResource(R.drawable.zombie);
                                break;
                            case 2:
                                imgv.setImageResource(R.drawable.bat);
                                break;
                            case 3:
                                imgv.setImageResource(R.drawable.blackcat);
                                break;
                        }
                    }
                });
//                dlg.setMessage("513호에 타과 학생이 만약에 있다면 추방해주시기 바랍니다.");
                dlg.setIcon(R.drawable.night);
                dlg.setPositiveButton("닫기", null);
//                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(MainActivity.this, "취소버튼 클릭", Toast.LENGTH_SHORT).show();
//                            }
//                        });
                        dlg.show();
            }
        });
    }
}