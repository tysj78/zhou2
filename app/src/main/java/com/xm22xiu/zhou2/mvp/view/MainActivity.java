package com.xm22xiu.zhou2.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.xm22xiu.zhou2.R;
import com.xm22xiu.zhou2.mvp.view.fragment.OneFragment;
import com.xm22xiu.zhou2.mvp.view.fragment.ThreeFragment;
import com.xm22xiu.zhou2.mvp.view.fragment.TwoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 测试页，启动页为Main2activity
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_rg)
    RadioGroup mainRg;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        initRg();
    }

    private void initRg() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl, new OneFragment()).commit();
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_rb1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl, new OneFragment()).commit();
                        break;
                    case R.id.main_rb2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl, new TwoFragment()).commit();
                        break;
                    case R.id.main_rb3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl, new ThreeFragment()).commit();
                        break;
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
