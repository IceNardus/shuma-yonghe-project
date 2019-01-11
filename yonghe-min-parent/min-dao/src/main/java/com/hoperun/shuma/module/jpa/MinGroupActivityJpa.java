package com.hoperun.shuma.module.jpa;

import com.hoperun.shuma.base.BaseJpa;
import com.hoperun.shuma.bean.MinGroupActivity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 6/11/2018
 * Time: 1:40 PM
 */
@Repository
public interface MinGroupActivityJpa extends BaseJpa<MinGroupActivity> {

    /**
     * 根据当前类型获取当前活动
     * @param activityType
     * @return
     */
    @Query(value = "select * from min_activity where delete_status ='Valid' and shelf=1 and interim_shelf=1 and now()>=start_time and now()<end_time and activity_type =?1", nativeQuery = true)
    MinGroupActivity getCurActivity(String  activityType);

    /**
     * 获取活动类型集合
     * @param activityType
     * @return
     */
    @Query(value = "select * from min_activity where delete_status ='Valid' and shelf=1 and interim_shelf=1 and now()>=start_time and now()<end_time and activity_type =?1 order by top", nativeQuery = true)
    List<MinGroupActivity> getCurActivityList(String  activityType);

    /**
     *
     * @param activityType
     * @return
     */
    @Query(value = "select * from min_activity where delete_status ='Valid' and shelf=1 and interim_shelf=1 and now()>=start_time and now()<end_time and activity_type =?1 order by sort", nativeQuery = true)
    List<MinGroupActivity> getActivityOrderBySort(String activityType);
}
