package jmm.baselibrary.data.protocol

/**
 * user:Administrator
 * time:2018 04 09 11:37
 * package_name:jmm.baselibrary.data.protocol
 */
class BaseResp<out T>(val status:Int, val message:String, val data:T) {

}