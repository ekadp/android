package com.example.bluetooth;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.Set;


/* --- HOW TO USE ---
* To use this Java class, all you need to do is doing these steps:
*
* Preparation:
* - Call the singleton method.
* - Set the ActContext & Context using setAllContexts() method.
* - Call init() method to initialize bluetooth adapter.
* - Call method on(), to enable bluetooh adapter.
*
* Usage:
* - After method on() has been called, like explanation above, then
*   you can just list the device connected to your phone using bluetooth
*   in nearby places.
* - You can also use getAllDevicesInString() method, to list all devices name.
* - You can also use getAllDeviceByName() method, to get a device by name, i.e: TM-U220.
*
* Note:
* - if necessary, ask Permission for Bluetooth & Bluetooth Admin using askPermission() method.
* - MessageBox is a custom alert dialog I made for my coding purpose. You can simply
*   replace it with regular Toast.
* */


public class MyBlueTooth {
    //--- Variable Declaractions ---
    private BluetoothAdapter mAdapter = null;
    public static MyBlueTooth mInstance = null;
    Context mContext, mActContext;

    final int REQUEST_CODE_PERMISSION = 100;
    final String BLUETOOTH_PERMISSION = Manifest.permission.BLUETOOTH;
    final String BLUETOOTH_PERMISSION_ADMIN = Manifest.permission.BLUETOOTH_ADMIN;

    Intent mIntent;




    /* For better app, you should put permission in Manifest.
     *
     * But just in case, that is not enough, hence I provide method for
     * asking user permission purpose in below method. */
    void askPermission() {
        ActivityCompat.requestPermissions((Activity) mContext,
                new String[] {BLUETOOTH_PERMISSION, BLUETOOTH_PERMISSION_ADMIN},
                REQUEST_CODE_PERMISSION);


        //--- Check if the permission has been granted by user ---
        if (ActivityCompat.checkSelfPermission(mContext, BLUETOOTH_PERMISSION) !=
                PackageManager.PERMISSION_GRANTED) {

            //For permission, prefer to use MessageBox rather than Toast, due to ability to show as modal box
            String message = mActContext.getResources().getString(R.string.ask_permission);
            MessageBox msg = new MessageBox(mActContext, message);
            msg.tampil();

            //Re-ask the permission to user
            ActivityCompat.requestPermissions((Activity) mContext, new String[]
                    {BLUETOOTH_PERMISSION}, REQUEST_CODE_PERMISSION);
        }//if-check-self-permission


        //--- Check if the permission has been granted by user ---
        if (ActivityCompat.checkSelfPermission(mContext, BLUETOOTH_PERMISSION_ADMIN) !=
                PackageManager.PERMISSION_GRANTED) {

            //For permission, prefer to use MessageBox rather than Toast, due to ability to show as modal box
            String message = mActContext.getResources().getString(R.string.ask_permission);
            MessageBox msg = new MessageBox(mActContext, message);
            msg.tampil();

            //Re-ask the permission to user
            ActivityCompat.requestPermissions((Activity) mContext, new String[]
                    {BLUETOOTH_PERMISSION_ADMIN}, REQUEST_CODE_PERMISSION);
        }//if-check-self-permission
    }//ask-permission



    //Singleton so this class can be accessed anywhere
    public static MyBlueTooth getInstance() {
        if (mInstance == null) {
            mInstance = new MyBlueTooth();
        }
        return mInstance;
    }//singleton



    /* mActContext is a context from Activity, it will probably used later.
     * mContext is a context from latest views. */
    void setAllContexts(Context actContext, Context context) {
        mActContext = actContext;
        mContext = context;
    }//method-set-all-contexts



    /* Init is initialize Adapter for Bluetooth */
    void init() {
        if (mAdapter == null) {
            mAdapter = BluetoothAdapter.getDefaultAdapter();
        }
    }//method-init



    public void on(){
        //if isEnabled() == true then adapter already enabled; if not, then need to be enabled
        if (! mAdapter.isEnabled()) {
            mIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            ((Activity) mActContext).startActivityForResult(mIntent, 0);
        }
    }//method-on



    /* Method to disable / turn-off adapter for bluetooth. */
    public void off(){
        mAdapter.disable();
    }//method-off



    /* Get Visible is to make our device visible to other devices arround */
    public  void visible(){
        mIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        ((Activity) mActContext).startActivityForResult(mIntent, 0);
    }//method-activity



    /* --- GET ALL DEVICES METHOD ---
     * This method will list all devices connected to you using bluetooth in nearby places.
     *
     * After all devices connected using bluetooth are found, then we list all
     * the devices as a set of BluetoothDevice.
     *
     * In BluetoothDevice we can get device name, by using getName() method.
     * This way, using for, we can store devices name in array list.
     *
     * By the way, I can make these two methods below shorter, but I prefer to do it so,
     * hence it enhances readability of the codes.
     *  */
    public Set<BluetoothDevice> getAllDevices(){
        /* GET ALL DEVICES ARROUND SEEN BY BLUETOOTH
         * - First, using "getBondedDevices()", we get all devices arround.
         * - Second, we put it into array list of string.
         *  */
        Set<BluetoothDevice> devices = mAdapter.getBondedDevices();

        return devices;
    }



    public ArrayList<String> getAllDevicesInString(){
        Set<BluetoothDevice> devices = getAllDevices();

        //Put it into array list
        ArrayList<String> list = new ArrayList();
        for (BluetoothDevice dev : devices) {
            list.add(dev.getName());  //device name, i.e: TM-U220
        }

        return list;
    }//method-get-devices



    public BluetoothDevice getDeviceByName(String name) {
        BluetoothDevice resultdevice = null;

        //Get All Devices
        Set<BluetoothDevice> devices = getAllDevices();

        //Get The Device By Name
        name = name.trim().toLowerCase();
        for (BluetoothDevice dev : devices) {
            //dev.getName() = device name, i.e: TM-U220
            if (name.equals(dev.getName().trim().toLowerCase())) {
                resultdevice = dev;
                break;
            }
        }//for

        //Return The Device, will be null if not found
        return resultdevice;
    }//method-get-device
}//class-mybluetooth




