package com.csu.carefree.Service;


import com.csu.carefree.Model.ProductDT.*;
import com.csu.carefree.Model.TraverAsk.TraverNote;
import com.csu.carefree.Model.TraverMsg.CityMsg;
import com.csu.carefree.Model.TraverMsg.ProvinceMsg;
import com.csu.carefree.Model.TraverMsg.ScenicMsg;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatalogService {

    /*******************酒店信息**********/
    //通过销量获取热门酒店列表
    List<HotelMsg> getHotelList();

    //获取酒店具体信息
    HotelMsg getHotelMsg(String hotelId);

    //通过用户输入的目的地获取酒店信息
    List<HotelMsg> getHotelListByDestination(String destination);

    //通过关键词搜索获取酒店信息
    List<HotelMsg> getHotelListByKeyword(String keyword);

    List<ProductMsg> getProductList();

    ProductMsg getProductById(String id);

    /*****************通过筛选条件获取产品*****************/
    //筛选条件：traver_days, product_type, supplier_id

    //行程天数
    List<ProductMsg> getProductListByTraver_days(String traver_days);

    //产品类型
    List<ProductMsg> getProductListByProduct_type(String product_type);

    //供应商
    List<ProductMsg> getProductListBySupplier_id(String supplier_id);

    //产品名称
    List<ProductMsg> getProductListByName(String product_name);

    //三个筛选条件都有
    List<ProductMsg> getProductListByThree(String traver_days, String product_type, String supplier_id);

    //*****************通过推荐条件来排序、推荐*****************/
    //注意：推荐条件是在筛选条件的基础上进行的，所以不能直接对数据库进行查找
    //推荐（排序）条件：score, sell_num, comments_num, product_grade

    /*******供应商信息*****/
    //获取供应商列表
    List<Supplier> getSupplierList();

    //例如当点击产品当中的供应商信息时候，要返回相应的信息
    Supplier getSupplierByName(String name);

    /*******城市信息*******/
    //通过省份ID获取省份信息
    ProvinceMsg getProvinceMsgById(String provinceId);

    //通过城市ID获取城市信息
    CityMsg getCityMsgById(String cityId);

    //通过城市名称获取城市信息(模糊搜索)
    List<CityMsg> searchCityMsgByName(String cityName);

    //通过城市ID获取城市所有景点信息
    List<ScenicMsg> getScenicMsgListById(String cityId);

    //通过城市名字获取城市所有景点信息
    List<ScenicMsg> getScenicMsgListByCityName(String cityName);

    /***********景点信息*********/
    //通过景点ID获取景点信息
    ScenicMsg getScenicMsgById(String scenicId);

    //通过景点名称获取景点信息
    List<ScenicMsg> getScenicMsgListByName(String name);

    /*************产品城市信息*****/
    //获得产品的所有有关城市信息
    List<Product_CityMsg> getProduct_CityList();

    //根据产品ID找出产品的所有出发城市以及相应的起价
    List<Product_CityMsg> getAllDepartCityListByProductId(String product_id);

    //根据产品ID以及出发城市名字查找相应的起价
    Product_CityMsg getADepartCity_Price(String Product_id, String cityName);

    /*****************产品景点信息******/
    //根据景点名字查找产品列表
    List<Product_ScenicMsg> getProductIdsByScenicName(String scenicName);

    //根据产品ID查找景点名字列表
    List<Product_ScenicMsg> getScenicNamesByProductId(String ProductId);

    /***************攻略信息****/
    // 得到攻略信息
    List<StrategyMsg> getStrategyList();

    // 根据景点得到
    StrategyMsg getStrategyByScenic_name(String scenic_name);

    /*****************门票信息0******/
    //得到所有门票信息
    List<TicketMsg> getTicketList();

    //门票查询筛选信息有：景点名字、城市名字
    List<TicketMsg> getTicketListByScenic_name(String scenic_name);

    List<TicketMsg> getTicketListByCity_id(String city_id);

    /**************游记信息*******/
    //获取所有游记信息
    List<TraverNote> getTraverNoteList();

    //通过关键词搜索游记信息
    List<TraverNote> searchTraverNoteList(String keyword);

    //通过游记ID获取游记信息
    TraverNote getTraverNoteById(String traverNoteId);

    //存储用户游记信息
    void insertTraverNote(TraverNote traverNote);
}
