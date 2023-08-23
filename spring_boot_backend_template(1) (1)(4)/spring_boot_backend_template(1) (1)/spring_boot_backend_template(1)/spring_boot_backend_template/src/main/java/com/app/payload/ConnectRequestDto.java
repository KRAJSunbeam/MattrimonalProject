package com.app.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConnectRequestDto {
	  private Long senderId;
	    private Long receiverId;
}
