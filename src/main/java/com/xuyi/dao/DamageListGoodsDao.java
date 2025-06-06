package com.xuyi.dao;

import com.xuyi.entity.DamageList;
import com.xuyi.entity.DamageListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface DamageListGoodsDao {

    Integer saveDamageList(DamageList damageList);

    Integer saveDamageListGoods(DamageListGoods damageListGoods);

    List<DamageList> getDamagelist(@Param("sTime") String sTime,@Param("eTime") String eTime);

    List<DamageListGoods> getDamageListGoodsByDamageListId(Integer damageListId);
}
