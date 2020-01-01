// -*- Java -*-
/*!
 * @file  NavigationManagerTestImpl.java
 * @brief Mapper Viewer RTC
 * @date  $Date$
 *
 * $Id$
 */

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import RTC.TimedPose2D;
import RTC.RangeData;
import RTC.CameraImage;
import RTC.Path2D;
import RTC.TimedVelocity2D;
import RTC.Waypoint2D;
import jp.go.aist.rtm.RTC.DataFlowComponentBase;
import jp.go.aist.rtm.RTC.Manager;
import jp.go.aist.rtm.RTC.port.InPort;
import jp.go.aist.rtm.RTC.port.OutPort;
import jp.go.aist.rtm.RTC.util.DataRef;
import jp.go.aist.rtm.RTC.port.CorbaConsumer;
import jp.go.aist.rtm.RTC.port.CorbaPort;
import jp.go.aist.rtm.RTC.util.IntegerHolder;
import jp.go.aist.rtm.RTC.util.DoubleHolder;
import RTC.ReturnCode_t;

/*!
 * @class NavigationManagerTestImpl
 * @brief Mapper Viewer RTC
 *
 */
public class NavigationManagerTestImpl extends DataFlowComponentBase {

  /*!
   * @brief constructor
   * @param manager Maneger Object
   */
	public NavigationManagerTestImpl(Manager manager) {  
        super(manager);
        // <rtc-template block="initializer">
        m_targetVelocity_val = new TimedVelocity2D();
        initializeParam(m_targetVelocity_val);
        m_targetVelocity = new DataRef<TimedVelocity2D>(m_targetVelocity_val);
        m_targetVelocityIn = new InPort<TimedVelocity2D>("targetVelocity", m_targetVelocity);
        m_goal_val = new Waypoint2D();
        initializeParam(m_goal_val);
        m_goal = new DataRef<Waypoint2D>(m_goal_val);
        m_goalIn = new InPort<Waypoint2D>("goal", m_goal);
        m_currentPose_val = new TimedPose2D();
        m_currentPose = new DataRef<TimedPose2D>(m_currentPose_val);
        m_currentPoseOut = new OutPort<TimedPose2D>("currentPose", m_currentPose);
        m_range_val = new RangeData();
        m_range = new DataRef<RangeData>(m_range_val);
        m_rangeOut = new OutPort<RangeData>("range", m_range);
        m_camera_val = new CameraImage();
        m_camera = new DataRef<CameraImage>(m_camera_val);
        m_cameraOut = new OutPort<CameraImage>("camera", m_camera);
        m_path_val = new Path2D();
        m_path = new DataRef<Path2D>(m_path_val);
        m_pathOut = new OutPort<Path2D>("path", m_path);
        m_mapperServicePort = new CorbaPort("mapperService");
        m_mapServerPort = new CorbaPort("mapServer");
        m_pathPlannerPort = new CorbaPort("pathPlanner");
        m_pathFollowerPort = new CorbaPort("pathFollower");
        // </rtc-template>

    }

    /*!
     *
     * The initialize action (on CREATED->ALIVE transition)
     * formaer rtc_init_entry() 
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
    @Override
    protected ReturnCode_t onInitialize() {
        // Registration: InPort/OutPort/Service
        // <rtc-template block="registration">
        // Set InPort buffers
        addInPort("targetVelocity", m_targetVelocityIn);
        addInPort("goal", m_goalIn);
        
        // Set OutPort buffer
        addOutPort("currentPose", m_currentPoseOut);
        addOutPort("range", m_rangeOut);
        addOutPort("camera", m_cameraOut);
        addOutPort("path", m_pathOut);
        
        // Set service consumers to Ports
        
        // Set CORBA Service Ports
        addPort(m_mapperServicePort);
        addPort(m_mapServerPort);
        addPort(m_pathPlannerPort);
        addPort(m_pathFollowerPort);
        // </rtc-template>
        bindParameter("debug", m_debug, "0");
        bindParameter("interval", m_interval, "1.0");
        bindParameter("pathDistanceTolerance", m_pathDistanceTolerance, "1.0");
        bindParameter("pathHeadingTolerance", m_pathHeadingTolerance, "1.0");
        return super.onInitialize();
    }

    /***
     *
     * The finalize action (on ALIVE->END transition)
     * formaer rtc_exiting_entry()
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onFinalize() {
//        return super.onFinalize();
//    }

    /***
     *
     * The startup action when ExecutionContext startup
     * former rtc_starting_entry()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onStartup(int ec_id) {
//        return super.onStartup(ec_id);
//    }

    /***
     *
     * The shutdown action when ExecutionContext stop
     * former rtc_stopping_entry()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onShutdown(int ec_id) {
//        return super.onShutdown(ec_id);
//    }

    /***
     *
     * The activated action (Active state entry action)
     * former rtc_active_entry()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
    @Override
    protected ReturnCode_t onActivated(int ec_id) {
        return super.onActivated(ec_id);
    }

    /***
     *
     * The deactivated action (Active state exit action)
     * former rtc_active_exit()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
    @Override
    protected ReturnCode_t onDeactivated(int ec_id) {
        return super.onDeactivated(ec_id);
    }

    /***
     *
     * The execution action that is invoked periodically
     * former rtc_active_do()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
    @Override
    protected ReturnCode_t onExecute(int ec_id) {
        return super.onExecute(ec_id);
    }

    /***
     *
     * The aborting action when main logic error occurred.
     * former rtc_aborting_entry()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//  @Override
//  public ReturnCode_t onAborting(int ec_id) {
//      return super.onAborting(ec_id);
//  }

    /***
     *
     * The error action in ERROR state
     * former rtc_error_do()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
    @Override
    public ReturnCode_t onError(int ec_id) {
        return super.onError(ec_id);
    }

    /***
     *
     * The reset action that is invoked resetting
     * This is same but different the former rtc_init_entry()
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
    @Override
    protected ReturnCode_t onReset(int ec_id) {
        return super.onReset(ec_id);
    }

    /***
     *
     * The state update action that is invoked after onExecute() action
     * no corresponding operation exists in OpenRTm-aist-0.2.0
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onStateUpdate(int ec_id) {
//        return super.onStateUpdate(ec_id);
//    }

    /***
     *
     * The action that is invoked when execution context's rate is changed
     * no corresponding operation exists in OpenRTm-aist-0.2.0
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onRateChanged(int ec_id) {
//        return super.onRateChanged(ec_id);
//    }
//
	// Configuration variable declaration
	// <rtc-template block="config_declare">
    /*!
     * 
     * - Name:  debug
     * - DefaultValue: 0
     */
    protected IntegerHolder m_debug = new IntegerHolder();
    /*!
     * 
     * - Name:  interval
     * - DefaultValue: 1.0
     */
    protected DoubleHolder m_interval = new DoubleHolder();
    /*!
     * 
     * - Name:  pathDistanceTolerance
     * - DefaultValue: 1.0
     */
    protected DoubleHolder m_pathDistanceTolerance = new DoubleHolder();
    /*!
     * 
     * - Name:  pathHeadingTolerance
     * - DefaultValue: 1.0
     */
    protected DoubleHolder m_pathHeadingTolerance = new DoubleHolder();
	// </rtc-template>

    // DataInPort declaration
    // <rtc-template block="inport_declare">
    protected TimedVelocity2D m_targetVelocity_val;
    protected DataRef<TimedVelocity2D> m_targetVelocity;
    /*!
     */
    protected InPort<TimedVelocity2D> m_targetVelocityIn;

    protected Waypoint2D m_goal_val;
    protected DataRef<Waypoint2D> m_goal;
    /*!
     */
    protected InPort<Waypoint2D> m_goalIn;

    
    // </rtc-template>

    // DataOutPort declaration
    // <rtc-template block="outport_declare">
    protected TimedPose2D m_currentPose_val;
    protected DataRef<TimedPose2D> m_currentPose;
    /*!
     */
    protected OutPort<TimedPose2D> m_currentPoseOut;

    protected RangeData m_range_val;
    protected DataRef<RangeData> m_range;
    /*!
     */
    protected OutPort<RangeData> m_rangeOut;

    protected CameraImage m_camera_val;
    protected DataRef<CameraImage> m_camera;
    /*!
     */
    protected OutPort<CameraImage> m_cameraOut;

    protected Path2D m_path_val;
    protected DataRef<Path2D> m_path;
    /*!
     */
    protected OutPort<Path2D> m_pathOut;

    
    // </rtc-template>

    // CORBA Port declaration
    // <rtc-template block="corbaport_declare">
    /*!
     */
    protected CorbaPort m_mapperServicePort;
    /*!
     */
    protected CorbaPort m_mapServerPort;
    /*!
     */
    protected CorbaPort m_pathPlannerPort;
    /*!
     */
    protected CorbaPort m_pathFollowerPort;
    
    // </rtc-template>

    // Service declaration
    // <rtc-template block="service_declare">
    /*!
     */
    protected OGMapperSVC_impl m_mapper = new OGMapperSVC_impl();
    /*!
     */
    protected OGMapServerSVC_impl m_OGMapServer = new OGMapServerSVC_impl();
    /*!
     */
    protected PathPlannerSVC_impl m_pathPlanner = new PathPlannerSVC_impl();
    /*!
     */
    protected PathFollowerSVC_impl m_pathFollower = new PathFollowerSVC_impl();
    
    // </rtc-template>

    // Consumer declaration
    // <rtc-template block="consumer_declare">
    
    // </rtc-template>


	private void initializeParam(Object target) {
		Class<?> targetClass = target.getClass();
		ClassLoader loader = target.getClass().getClassLoader();
		//
		Field[] fields = targetClass.getFields();
		for(Field field : fields) {
			if(field.getType().isPrimitive()) continue;
			
			try {
				if(field.getType().isArray()) {
					Object arrayValue = null;
					Class<?> clazz = null;
					if(field.getType().getComponentType().isPrimitive()) {
						clazz = field.getType().getComponentType();
					} else {
							clazz = loader.loadClass(field.getType().getComponentType().getName());
					}
					arrayValue = Array.newInstance(clazz, 0);
					field.set(target, arrayValue);
					
				} else {
					Constructor<?>[] constList = field.getType().getConstructors();
					if(constList.length==0) {
						Method[] methodList = field.getType().getMethods();
						for(Method method : methodList) {
							if(method.getName().equals("from_int")==false) continue;
							Object objFld = method.invoke(target, new Object[]{ new Integer(0) });
							field.set(target, objFld);
							break;
						}
						
					} else {
			            Class<?> classFld = Class.forName(field.getType().getName(), true, loader);
						Object objFld = classFld.newInstance();
						initializeParam(objFld);
						field.set(target, objFld);
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}
