package t.s.com.appservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {
    public void onCreate() {
        super.onCreate();
       Log.i("tttt","onCreate");
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myAidlInterface;
    }


    private final IMyAidlInterface.Stub myAidlInterface= new IMyAidlInterface.Stub() {
        @Override
        public String getMsg() throws RemoteException {
            Log.i("tttt","getMsg");
            return "我的AIDL";
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            Log.i("tttt","basicTypes");
        }
    };
}
