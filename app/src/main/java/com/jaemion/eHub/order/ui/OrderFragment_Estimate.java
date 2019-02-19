package com.jaemion.eHub.order.ui;

import android.app.DatePickerDialog;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.os.Bundle;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.databinding.OrderFragmentEstimateBinding;
import com.jaemion.eHub.order.OrderActivity;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderFragment_Estimate extends Fragment implements View.OnClickListener {

    private OrderViewModel mViewModel;

    public static OrderFragment_Estimate newInstance() {
        return new OrderFragment_Estimate();
    }

    OrderFragmentEstimateBinding binding;
    DatePickerDialog.OnDateSetListener startListener, finishListener;
    String startDate, finishDate;
    int numOfCar = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_fragment_estimate, container, false);

        binding.orderFragmentEstimateIvCalendar.setOnClickListener(this);
        binding.orderFragmentEstimateIvInfo1.setOnClickListener(this);
        binding.orderFragmentEstimateIvInfo2.setOnClickListener(this);
        binding.orderFragmentEstimateIvInfo3.setOnClickListener(this);
        binding.orderFragmentEstimateBtnOrder.setOnClickListener(this);
        binding.orderFragmentEstimateBtnMinus.setOnClickListener(this);
        binding.orderFragmentEstimateBtnPlus.setOnClickListener(this);

        startListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.YEAR, year);
                c.set(Calendar.MONTH, month);
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String currentDateString = new SimpleDateFormat("yyyy년 MMM dd일 (E)").format(c.getTime());
                binding.orderFragmentEstimateTvOrderDurationSelect.setText(currentDateString + "- yyyy-mm-dd");
                startDate = currentDateString;

                DatePickerDialog pickerDialog = new DatePickerDialog(getActivity(), finishListener, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                pickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());

                try {
                    pickerDialog.getDatePicker().setMaxDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-31").getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                pickerDialog.show();
            }
        };
        finishListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.YEAR, year);
                c.set(Calendar.MONTH, month);
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String currentDateString = new SimpleDateFormat("yyyy년 MMM dd일 (E)").format(c.getTime());
                binding.orderFragmentEstimateTvOrderDurationSelect.setText(startDate + " - " + currentDateString);
                finishDate = currentDateString;
            }
        };

        binding.orderFragmentEstimateSpinnerOption.setPrompt("옵션을 선택해주세요");
        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(getActivity(), R.array.option, android.R.layout.simple_spinner_item);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.orderFragmentEstimateSpinnerOption.setAdapter(aa);
        binding.orderFragmentEstimateSpinnerOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("asdf", parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(OrderViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onResume() {
        super.onResume();
        ((OrderActivity) getActivity()).setToolbar("발주하기");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*if(requestCode == 1 && resultCode == RESULT_OK){
            Uri uri = data.getData();
            ClipData clipData = data.getClipData();

            if(clipData!=null)
            {
                for(int i = 0; i < 3; i++)
                {
                    if(i<clipData.getItemCount()){
                        Uri urione =  clipData.getItemAt(i).getUri();
                        switch (i){
                            case 0:
                                ivInfo1.setImageURI(urione);
                                break;
                            case 1:
                                ivInfo2.setImageURI(urione);
                                break;
                            case 2:
                                ivInfo3.setImageURI(urione);
                                break;
                        }
                    }
                }
            }
            else if(uri != null)
            {
                ivInfo1.setImageURI(uri);
            }*/

        Bitmap bitmap = null;
        ExifInterface exif = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
            exif = new ExifInterface(data.getData().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("asdf", exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED) + "");
        float ratio = bitmap.getWidth() / bitmap.getHeight();
        Log.d("asdf", "" + ratio);
        Log.d("asdf", bitmap.getHeight() + "");
        Log.d("asdf", bitmap.getWidth() + "");
        Bitmap temp = Bitmap.createScaledBitmap(bitmap, 1024, (int) (1024 * ratio), true);
        binding.orderFragmentEstimateIvInfo1.setImageBitmap(temp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.order_fragment_estimate_btnOrder:
                binding.orderFragmentEstimateEtOrderName.clearFocus();
                binding.orderFragmentEstimateEtLocation.clearFocus();
                binding.orderFragmentEstimateEtPay.clearFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(binding.orderFragmentEstimateEtOrderName.getWindowToken(), 0);
                inputMethodManager.hideSoftInputFromWindow(binding.orderFragmentEstimateEtLocation.getWindowToken(), 0);
                inputMethodManager.hideSoftInputFromWindow(binding.orderFragmentEstimateEtPay.getWindowToken(), 0);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in, R.anim.slide_right_out)
                        .replace(R.id.order_container, OrderFragment_Contract.newInstance())
                        .commit();
                break;

            case R.id.order_fragment_estimate_ivCalendar:
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog pickerDialog = new DatePickerDialog(getActivity(), startListener, year, month, day);
                pickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                try {
                    pickerDialog.getDatePicker().setMaxDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-31").getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                pickerDialog.show();
                break;

            case R.id.order_fragment_estimate_ivInfo1:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
                break;

            case R.id.order_fragment_estimate_btnMinus:
                if (numOfCar == 0)
                    break;
                numOfCar -= 1;
                binding.orderFragmentEstimateTvCurrentNumOfCar.setText(String.valueOf(numOfCar));
                break;

            case R.id.order_fragment_estimate_btnPlus:
                numOfCar += 1;
                binding.orderFragmentEstimateTvCurrentNumOfCar.setText(String.valueOf(numOfCar));
                break;
        }
    }
}
