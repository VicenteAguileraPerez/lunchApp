package fragmentsPackage;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lunchapp.MainActivity;
import com.example.lunchapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class quejasysugenencias extends Fragment {


    public quejasysugenencias() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quejasysugenencias, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(getActivity() instanceof MainActivity){
            ((MainActivity)getActivity()).activadoRetonrno(false);
            ((MainActivity)getActivity()).activadoToolBar(false);
        }
    }
}
