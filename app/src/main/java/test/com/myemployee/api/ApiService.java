package test.com.myemployee.api;

import retrofit2.http.GET;
import rx.Observable;
import test.com.myemployee.pojo.EmployeeResponse;

public interface ApiService {

    @GET("testTask.json")
    Observable<EmployeeResponse> getEmployees();
}
