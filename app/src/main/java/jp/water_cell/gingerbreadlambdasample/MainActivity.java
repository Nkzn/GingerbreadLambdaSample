package jp.water_cell.gingerbreadlambdasample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Integer> numbers = Arrays.asList(-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<String> evenNumbers = Stream.of(numbers)
                .filter(number -> number > 0) // Lambda! Yeah!
                .map(this::crazyWhenMultipleOfThree) // Amazing! Method Reference!!
                .collect(Collectors.toList());

        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText(TextUtils.join(", ", evenNumbers));
    }

    private String crazyWhenMultipleOfThree(int number) {
        switch (number) {
            case 3: return "さぁん！";
            case 6: return "ろぉく！";
            case 9: return "きゅーう！";
            default: return String.valueOf(number);
        }
    }
}
