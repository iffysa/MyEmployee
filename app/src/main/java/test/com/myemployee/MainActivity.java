package test.com.myemployee;


import android.os.Bundle;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import rx.schedulers.Schedulers;
import test.com.myemployee.adapters.EmployeeAdapter;
import test.com.myemployee.api.ApiFactory;
import test.com.myemployee.api.ApiService;
import test.com.myemployee.pojo.Employee;
import test.com.myemployee.pojo.EmployeeResponse;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewEmployees;
    private List<Employee> employees;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewEmployees = findViewById(R.id.recycleViewEmployee);
        recyclerViewEmployees.setLayoutManager(new LinearLayoutManager(this));
        EmployeeAdapter adapter = new EmployeeAdapter();
        employees = new ArrayList<>();
        recyclerViewEmployees.setAdapter(adapter);
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        apiService.getEmployees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EmployeeResponse>() {
                    @Override
                    public void accept(EmployeeResponse employeeResponse) {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {

                    }
                });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
