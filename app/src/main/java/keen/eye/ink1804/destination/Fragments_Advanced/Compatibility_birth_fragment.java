package keen.eye.ink1804.destination.Fragments_Advanced;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import fr.ganfra.materialspinner.MaterialSpinner;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 28.08.16.
 */
public class Compatibility_birth_fragment extends Fragment implements View.OnClickListener {

    private View rootView;
    private ImageView imageView;
    private String birthYear;
    private String D_EqualMarriage, D_RomanticMarriage, D_SpiritualMarriage, D_PatriarchalMarriage, D_VectorMarriage;
    private int[] birthDrawables = {R.drawable.com_birth_monkey, R.drawable.com_birth_cock,R.drawable.com_birth_dog, R.drawable.com_birth_boar,
            R.drawable.com_birth_mouse, R.drawable.com_birth_bull, R.drawable.com_birth_tiger, R.drawable.com_birth_cat,
            R.drawable.com_birth_dragon, R.drawable.com_birth_snake, R.drawable.com_birth_horse,R.drawable.com_birth_goat};
    private String[] birthNames = {"Обезьяна","Петух","Собака","Кабан","Крыса","Бык",
            "Тигр","Кролик(Кот)","Дракон","Змея","Лошадь","Овца(Коза)"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.comp_birth_fragment_viewpager,container,false);
        initViews();
        return rootView;
    }
    private void initViews(){
        imageView = (ImageView)rootView.findViewById(R.id.comp_birth_image);
        MaterialSpinner spinner = (MaterialSpinner) rootView.findViewById(R.id.comp_birth_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item,
                birthNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setBackgroundResource(birthDrawables[i]);
                birthYear = birthNames[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button btn_result = (Button)rootView.findViewById(R.id.comp_birth_btn_result);
        btn_result.setOnClickListener(this);
        TextView tv_romantic = (TextView)rootView.findViewById(R.id.comp_birth_tv_romantic);
        tv_romantic.setOnClickListener(this);
        TextView tv_patriarch = (TextView)rootView.findViewById(R.id.comp_birth_tv_patriarch);
        tv_patriarch.setOnClickListener(this);
        TextView tv_soul = (TextView)rootView.findViewById(R.id.comp_birth_tv_soul);
        tv_soul.setOnClickListener(this);
        TextView tv_equal = (TextView)rootView.findViewById(R.id.comp_birth_tv_equal);
        tv_equal.setOnClickListener(this);
        TextView tv_vector = (TextView)rootView.findViewById(R.id.comp_birth_tv_vector);
        tv_vector.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String key = "default";
        String tag = "com_birth";
        pushDateListener listener = (pushDateListener)getActivity();
        switch (view.getId()){
            case R.id.comp_birth_tv_romantic:
                key = "Романтический брак";
                break;
            case R.id.comp_birth_tv_patriarch:
                key = "Патриархальный брак";
                break;
            case R.id.comp_birth_tv_soul:
                key = "Духовный брак";
                break;
            case R.id.comp_birth_tv_equal:
                key = "Равный брак";
                break;
            case R.id.comp_birth_tv_vector:
                key = "Векторный брак";
                break;
            case R.id.comp_birth_btn_result:
                //по нажатию на кнопку
                break;
            default: break;
        }
        listener.onDescriptionClicked(key,tag);//key is going to new bundle
    }
}