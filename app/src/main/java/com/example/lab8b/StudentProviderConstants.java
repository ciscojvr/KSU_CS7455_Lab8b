/*

Name: Francisco Ozuna Diaz
Assignment: CS 7455 Lab 8
Lab Date: Due July 19, 2020 at 11:59 PM

 */

package com.example.lab8b;

import android.net.Uri;

public interface StudentProviderConstants {

    Uri CONTENT_URI_1 = Uri.parse("content://com.example.lab8a/STUDENT_LIST");
    Uri CONTENT_URI_2 = Uri.parse("content://com.example.lab8a/STUDENT_COUNT");

    String COL_1 = "ID";
    String COL_2 = "NAME";
    String COL_3 = "GRADE";
}