package cn.yiport.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.yiport.ypapicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
 * @Entity cn.yiport.project.model.entity.UserInterfaceInfo
 */
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




