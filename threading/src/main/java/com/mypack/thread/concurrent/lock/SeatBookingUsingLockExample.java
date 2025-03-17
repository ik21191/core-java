package com.mypack.thread.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BookMyShow {
  Lock lock;
  private boolean[] seats;

  public BookMyShow(int total, Lock lock) {
    seats = new boolean[total];
    this.lock = lock;

    for (int i = 0; i < total; ++i) {
      seats[i] = true;
    }
  }

  public void bookSeat(String customerName, int seatNo) {
    if (seatNo < 0 || seatNo > seats.length)
      throw new RuntimeException("invalid booking request");

    lock.lock();
    try {
      if (seats[seatNo]) {
        seats[seatNo] = false;
        System.out.println(customerName + " has booked the seat No  " + seatNo);
      } else {
        System.out.println("Sorry " + customerName + " Seat is already Booked !");
      }
    } finally {
      lock.unlock();
    }
  }
}


public class SeatBookingUsingLockExample {
  public static void main(String[] args) {
    Lock lock = new ReentrantLock();
    BookMyShow bookMyShow = new BookMyShow(10, lock);
    Thread customer1 = new Thread(() -> {
      bookMyShow.bookSeat("Imran", 2);
    });
    Thread customer2 = new Thread(() -> {
      bookMyShow.bookSeat("Vinay", 2);
    });

    customer1.start();
    customer2.start();
  }
}
