package id.co.digitalindo.loginregisterandroid;

/**
 * Created by nandoseptianhusni on 3/1/18.
 */

//TODO 9 bikin kerangka response dari request register from server
public class ResponseRegister {

    //TODO 10 getter dari response biar bisa di get di class lain -> klik kanan -> generate ->getter


    public Boolean getError() {
        return error;
    }

    public String getError_msg() {
        return error_msg;
    }

    Boolean error ;

String error_msg ;
}
