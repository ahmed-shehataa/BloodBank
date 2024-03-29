package com.ashehata.bloodbank.data.local.sharedPreferenceManager;

import android.app.Activity;
import android.content.SharedPreferences;

import com.ashehata.bloodbank.data.model.ListModel;
import com.ashehata.bloodbank.data.model.donation.Donation;
import com.ashehata.bloodbank.data.model.login.LoginData;
import com.ashehata.bloodbank.data.model.posts.Posts;
import com.ashehata.bloodbank.data.model.updateProfile.UpdateProfileData;
import com.google.gson.Gson;

public class SharedPreferencesManger {

    private static SharedPreferences sharedPreferences = null;
    private static String USER_DATA = "USER_DATA";
    private static String USER_ID = "USER_ID";
    private static String USER_EMAIL = "USER_EMAIL";
    private static String USER_NAME = "USER_NAME";
    private static String USER_BID = "USER_BID";
    private static String USER_PHONE = "USER_PHONE";
    private static String USER_DLD = "USER_DLD";
    private static String USER_PIN_CODE = "USER_PIN_CODE";
    public static String USER_API_TOKEN = "USER_API_TOKEN";
    private static String USER_CITY_ID = "USER_CITY_ID";
    private static String USER_CITY_NAME = "USER_CITY_NAME";
    private static String USER_GOVERMENT_NAME = "USER_GOVERMENT_NAME";
    private static String USER_GOVERMENT_ID = "USER_GOVERMENT_ID";
    private static String USER_BLOOD_TYPE_ID = "USER_BLOOD_TYPE_ID";
    private static String USER_BLOOD_TYPE_NAME = "USER_BLOOD_TYPE_NAME";
    public static String USER_PASSWORD = "USER_PASSWORD";
    public static String REMEMBER = "REMEMBER";
    public static String USER_POSTS = "USER_POSTS";
    public static String USER_DONATION = "USER_DONATION";
    public static String IS_LIST_DOWNLOADED = "IS_LIST_DOWNLOADED";
    public static String LIST_MODEL = "LIST_MODEL";



    public static void setSharedPreferences(Activity activity) {
        if (sharedPreferences == null) {
            sharedPreferences = activity.getSharedPreferences(
                    "Blood", activity.MODE_PRIVATE);
        }
    }

    public static void SaveData(Activity activity, String data_Key, String data_Value) {
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(data_Key, data_Value);
            editor.commit();
        } else {
            setSharedPreferences(activity);
        }
    }

    public static void SaveData(Activity activity, String data_Key, boolean data_Value) {
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(data_Key, data_Value);
            editor.commit();
        } else {
            setSharedPreferences(activity);
        }
    }

    public static String LoadData(Activity activity, String data_Key) {
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
        } else {
            setSharedPreferences(activity);
        }

        return sharedPreferences.getString(data_Key, null);
    }

    public static boolean LoadBoolean(Activity activity, String data_Key) {
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
        } else {
            setSharedPreferences(activity);
        }

        return sharedPreferences.getBoolean(data_Key, false);
    }

    public static void SaveData(Activity activity, String data_Key, Object data_Value) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String StringData = gson.toJson(data_Value);
            editor.putString(data_Key, StringData);
            editor.commit();
        }
    }

    public static void saveUserData(Activity activity, Object userData) {
        SaveData(activity, USER_DATA, userData);
    }


    public static LoginData loadUserData(Activity activity) {
        LoginData userData = null;

        Gson gson = new Gson();
        userData = gson.fromJson(LoadData(activity, USER_DATA), LoginData.class);

        return userData;
    }

    public static Posts loadUserPosts(Activity activity) {
        Posts userPosts ;

        Gson gson = new Gson();
        userPosts = gson.fromJson(LoadData(activity, USER_POSTS), Posts.class);

        return userPosts;
    }
    public static Donation loadUserDonation(Activity activity) {
        Donation userData = null;

        Gson gson = new Gson();
        userData = gson.fromJson(LoadData(activity, USER_DONATION), Donation.class);

        return userData;
    }


    public static void saveUserPosts(Activity activity, Posts userPosts) {
        SaveData(activity, USER_POSTS, userPosts);
    }





    public static void clean(Activity activity) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();
        }
    }

    public static ListModel loadUserListModel(Activity activity) {
        ListModel userData = null;

        Gson gson = new Gson();
        userData = gson.fromJson(LoadData(activity, LIST_MODEL), ListModel.class);

        return userData;
    }


}
