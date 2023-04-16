package cn.yiport.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.yiport.ypapicommon.model.entity.InterfaceInfo;

/**
 *
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
