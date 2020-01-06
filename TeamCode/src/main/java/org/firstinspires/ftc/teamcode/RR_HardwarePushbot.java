/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */
public class RR_HardwarePushbot
{
    /* Public OpMode members. */
    // Locomotion
    public DcMotor  leftFrontDrive   = null;
    public DcMotor  rightFrontDrive  = null;
    public DcMotor  leftBackDrive   = null;
    public DcMotor  rightBackDrive  = null;
    public DcMotor  brickLift  = null;
    public DcMotor  bricklift2  =null;
    // Missions
    //public DcMotor  linearLift  = null;
    //public DcMotor  armElbow   = null;
    //public DcMotor  armBase  = null;
    //public DigitalChannel armBaseLimit = null;

    // RON TEST - UNDEFINED VARIABLES
    public Servo Foundation_Pull_1 = null;
    public Servo brickClaw = null;
  //  public Servo Foundation_Pull_2 = null;
    //public Servo Foundation_Pull = null;

    //public Servo    relicDrop = null;
    //public Servo    armAClaw = null;
    //public Servo    armAKnuckle = null;

    public int      linearLiftDistance = 170;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public RR_HardwarePushbot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftFrontDrive  = hwMap.get(DcMotor.class, "left_Front_Drive");
        rightFrontDrive = hwMap.get(DcMotor.class, "right_Front_Drive");
        leftBackDrive  = hwMap.get(DcMotor.class, "left_Back_Drive");
        rightBackDrive = hwMap.get(DcMotor.class, "right_Back_Drive");
        brickLift = hwMap.get(DcMotor.class, "brick_Lift");
        bricklift2  = hwMap.get(DcMotor.class, "brick_Lift2");
        Foundation_Pull_1 = hwMap.get(Servo.class, "Foundation_Pull_1");
        brickClaw = hwMap.get(Servo.class, "brick_Claw");
       // Foundation_Pull_2 = hwMap.get(Servo.class, "Foundation_Pull_2");

        //linearLift = hwMap.get(DcMotor.class, "linear_Lift");


        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);
        brickLift.setDirection(DcMotor.Direction.REVERSE);
        bricklift2.setDirection(DcMotor.Direction.REVERSE);
        //linearLift.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to zero power
        leftFrontDrive.setPower(0);
        rightFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightBackDrive.setPower(0);
        brickLift.setPower(0);
        bricklift2.setPower(0);
        //linearLift.setPower(0);


        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        brickLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bricklift2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //linearLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        // Define and initialize ALL installed servos.
        //relicDrop = hwMap.get(Servo.class, "relic_Drop");
        //relicDrop.setPosition(1.00);

        // Set arm servos and motors
        //armAClaw = hwMap.get(Servo.class, "arm_A_Claw");
        //armAKnuckle = hwMap.get(Servo.class, "arm_A_Knuckle");

        //armAClaw.setPosition(0);
        //armAKnuckle.setPosition(1);

        //armBase  = hwMap.get( DcMotor.class, "arm_Base" );
        //armElbow = hwMap.get( DcMotor.class, "arm_Elbow" );
        //armBaseLimit = hwMap.get(DigitalChannel.class, "arm_Base_Limit");

        //setArmMotor( armBase, DcMotorSimple.Direction.FORWARD );
        //setArmMotor( armElbow, DcMotorSimple.Direction.REVERSE );

    }


    private void setBrickLift( DcMotor motor, DcMotor.Direction direction ) {
        motor.setPower(0);
        motor.setDirection(direction);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
        private void setBrickLift2( DcMotor motor, DcMotor.Direction direction ){
            motor.setPower( 0 );
            motor.setDirection( direction );
            motor.setZeroPowerBehavior( DcMotor.ZeroPowerBehavior.BRAKE );
            motor.setMode( DcMotor.RunMode.RUN_TO_POSITION );
    }
 }

