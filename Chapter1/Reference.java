// 1、数据对象：xxxDO，xxx即为数据表名。
@Table(name = "t_ps_app")
public class AppDO extends BaseDO {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "rs id")
    private Integer rsId;
}

// 2、数据传输对象：xxxDTO，xxx为业务领域相关的名称。
// 2-1、数据查询对象：xxxQueryDTO，xxx为该数据表名和分页等。
public class AppPageQueryDto extends BaseQueryDto {
    @ApiModelProperty(value = "设备id(必传)", required = true)
    @NotNull(message = "VLD.global.deviceId")
    private Integer deviceId;
}

// 2-2、数据查询结果对象：xxxResultDTO，xxx为该数据表名和分页等。
public class AppPageResultDto {
    @ApiModelProperty(value = "id")
    private Integer id;
}

// 3、数据访问对象：xxxDAO，xxx即为数据库表名。
public interface AppDao extends BaseDAO<AppDO> {
    List<AppPageResultDto> page(@Param("queryDto") AppPageQueryDto dto);
}

// 4、服务层：xxxService，xxx即为数据库表名。
public interface AppService extends IConstants {
    PageInfo<AppPageResultDto> page(Integer pageNum, Integer pageSize, AppPageQueryDto dto);
}

// 5、实现服务层：xxxServiceImpl，xxx即为数据库表名。
@Service
@Transactional
@Slf4j
public class AppServiceImpl implements AppService {
    @Autowired
    private AppWhiteListService appWhiteListService;
    @Autowired
    private AppDao appDao;

    @Override
    public PageInfo<AppPageResultDto> page(Integer pageNum, Integer pageSize, AppPageQueryDto dto) {

    }
}