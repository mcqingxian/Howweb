package com.hoau.how.module.bse.server.service.company;

import java.util.List;

import com.hoau.how.module.bse.shared.vo.GisDestinationQueryResultDto;
import com.hoau.how.module.bse.shared.vo.NewExcelDataVo;
import com.hoau.how.module.bse.shared.vo.OldExcelDataVo;

public interface GisServer {
	public List<NewExcelDataVo> getGisResult(List<OldExcelDataVo> list, String outputPath);
	public GisDestinationQueryResultDto queryDestinationBoundsFromGis(String address, String latitude, String longitude);
}
