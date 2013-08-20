package com.test.searchapp;

import java.util.Arrays;
import java.util.List;

public class DataArray {
	
	static List<String> clothes = Arrays.asList("Clothes","Jeans","Shirts","Pants","Undergarments","Shorts");
	static List<String> sports = Arrays.asList("Sports","Cricket","Tennis","Football","Squash","Golf","Hockey");
	static List<String> hotels = Arrays.asList("Hotels","5 Star","Motels","Lodges","3 Star","Other");
	static List<String> furniture = Arrays.asList("Furniture","Chairs", "Tables", "Beds", "Dressers");
	static List<String> electronics = Arrays.asList("Electronics","Mobiles","TV","Cameras","Refrigerators","Microwave ovens", "Computers");
	static List<String> groceries = Arrays.asList("Groceries","Canned Food","Vegetables","Dairy","Meat","Snacks","Candy");
	static List<String> restaurants = Arrays.asList("Restaurants","Indian","Italian","Greek","Arabic","French","Pizzerias","Burgers","Fast Food");
	
	static List<String> allThings = Arrays.asList("Clothes", "Sports", "Hotels", "Furniture", "Electronics", "Groceries", "Restaurants"); 
	static List<List<String>> allArrays = Arrays.asList(clothes, sports, hotels, furniture, electronics, groceries, restaurants);

}
