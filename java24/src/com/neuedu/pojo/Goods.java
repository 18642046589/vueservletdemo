package com.neuedu.pojo;

public class Goods {
private int id;
private String goodsName;
private float goodsPrice;
private int goodsNumber;
private String filename;
private int cateid;
private int visits=0;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getGoodsName() {
	return goodsName;
}
public void setGoodsName(String goodsName) {
	this.goodsName = goodsName;
}
public float getGoodsPrice() {
	return goodsPrice;
}
public void setGoodsPrice(float goodsPrice) {
	this.goodsPrice = goodsPrice;
}
public int getGoodsNumber() {
	return goodsNumber;
}
public void setGoodsNumber(int goodsNumber) {
	this.goodsNumber = goodsNumber;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public int getCateid() {
	return cateid;
}
public void setCateid(int cateid) {
	this.cateid = cateid;
}
public int getVisits() {
	return visits;
}
public void setVisits(int visits) {
	this.visits = visits;
}



}
