package frc.robot.commands;

import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.LimelightHelpers;
import frc.robot.subsystems.Photonvision;
import frc.robot.subsystems.chassis;

public class SmartPhotonvision extends Command {
  private chassis newchassis;
  private Photonvision newPhotonvision;
  chassis myChassis = new chassis();            
    
  public SmartPhotonvision(chassis newchassis, Photonvision newPhotonvision) {
    this.newchassis = newchassis;
    this.newPhotonvision = newPhotonvision;

    addRequirements(this.newchassis, this.newPhotonvision);
  }

  public void getnumfromvision() {
    newPhotonvision.getvisionnum(); 

  }
  // public void autotarget() {
  // // double area = target.getArea();
  // // double Tag_X = LimelightHelpers.getTX("limelight"); // Use your actual
  // limelight name
  // PhotonTrackedTarget target = result.getBestTarget();
  // double yaw = target.getYaw();
  // double pitch = target.getPitch();
  // double area = target.getArea();
  // boolean hastarget = result.hasTargets();

  // if (Tag_X < 6 && Tag_X > -6 || Tag_X == 0) {
  // newchassis.stop();
  // if (Tag_Area < 6 && Tag_Area > 4 || Tag_Area == 0) {
  // newchassis.stop();
  // }
  // else if (Tag_Area >= 6) {
  // newchassis.backward();
  // }
  // else if (Tag_Area <= 4) {
  // newchassis.forward();
  // }
  // }
  // else if (Tag_X >= 6) {
  // newchassis.right();
  // }
  // else {
  // newchassis.left();
  // }
  // }

  @Override
  public void execute() {
    // newPhotonvision.getvisionnum();
    
    newPhotonvision.getnumfromVision();
    double yaw = newPhotonvision.getYaw();
    double area = newPhotonvision.putandget();
    boolean hasTarget = newPhotonvision.hasTarget();
       
    // SmartDashboard.putNumber("getY", yaw);
    // SmartDashboard.putNumber("getA",area);
    // double Yaw = SmartDashboard.getNumber("getY", 0);
    // double Pitch= SmartDashboard.getNumber("getP", 0);
    // double Area = SmartDashboard.getNumber("getA", 0);        
            


    if (newPhotonvision.isornot()) {
      
      if(area<1){
        myChassis.forward();
      }
      else if(area>4){
        myChassis.backward();
      }
      else if(yaw>13){
        myChassis.stop();
      }
      else if(yaw<-14) {
        myChassis.left();
      }
      else if (area==0){
        myChassis.right();
      }
      else{
        myChassis.stop();
      }
      

  //     if (area < 6 && Tag_X > -6 || Tag_X == 0) {
  //       newchassis.stop();

  //       if (Tag_Area < 6 && Tag_Area > 4 || Tag_Area == 0) {
  //         stop();
  //       } else if (Tag_Area >= 6) {
  //         backward();
  //       } else if (Tag_Area <= 4) {
  //         forward();
  //       }
  //     } else if (Tag_X >= 6) {
  //       right();
  //     } else {
  //       left();
  //     }
  //   } else {
  //     visionstop();
  //   }
  // }

}
  }

  @Override
  public void end(boolean interrupted) {
    myChassis.stop();
  }
}
  
//   public void periodic() {
//     letsgo();
//   }
// }