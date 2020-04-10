import React, { useState } from "react";
import { Button, Grid, Typography, TextField } from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles";
import VideoCallIcon from "@material-ui/icons/VideoCall";

const useStyles = makeStyles({
  container: {
    margin: "1rem",
  },
  message: {
    border: "1px solid gray",
    background: "WhiteSmoke",
    padding: "0.8rem",
    marginTop: "1rem",
    borderRadius: "8px",
    width: "48%",
  },
  senderName: {
    fontSize: "1.2rem",
  },
  partner: {
    border: "1px solid #00B5AD",
    background: "#F2FBFB",
    alignSelf: "flex-end",
  },

  image: {
    padding: "1rem 0",
    width: "100%",
  },

  videoButton: {
    background: "#00B5AD",
    color: "white",
    height: "40px",
    "&:hover": {
      background: "#00B5AD",
    },
  },

  sendButton: {
    background: "#00B5AD",
    color: "white",
    minWidth: "7rem",
    height: "3.85rem",
    borderRadius: "0 4px 4px 0",
    "&:hover": {
      background: "#00B5AD",
    },
  },
});

const ChatContainer = ({ chatsData, partner, onClick }) => {
  let [inputData, setInputData] = useState("");
  const classes = useStyles();
  return (
    <>
      {!chatsData ? (
        <p>Select conversation</p>
      ) : (
        <Grid
          className={classes.container}
          container
          style={{
            height: "700px",
          }}
        >
          <Grid container justify="space-between" alignContent="center">
            <Typography variant="h5">{partner}</Typography>
            <Button
              variant="contained"
              className={classes.videoButton}
              startIcon={<VideoCallIcon>send</VideoCallIcon>}
            >
              Video Call
            </Button>
          </Grid>
          <Grid
            container
            direction="column"
            wrap="nowrap"
            style={{
              height: "80%",
              overflowY: "auto",
            }}
          >
            {chatsData.map((message, index) => (
              <Grid
                key={index}
                className={`${classes.message} ${
                  message.partner || classes.partner
                }`}
              >
                <Typography className={classes.senderName} variant="h6">
                  {message.sender}
                </Typography>
                {message.attachment && (
                  <img
                    className={classes.image}
                    src={message.attachment}
                    alt="attachment"
                  ></img>
                )}

                {message.message && (
                  <Typography variant="body1">{message.message}</Typography>
                )}
              </Grid>
            ))}
          </Grid>

          <Grid container direction="row" alignContent="center" wrap="nowrap">
            <TextField
              fullWidth
              id="message_input"
              variant="outlined"
              placeholder="Input your message..."
              value={inputData}
              onChange={(event) => setInputData(event.target.value)}
            ></TextField>
            <Button
              className={classes.sendButton}
              onClick={() => {
                inputData && onClick(inputData);
                setInputData("");
              }}
            >
              Send
            </Button>
          </Grid>
        </Grid>
      )}
    </>
  );
};

export default ChatContainer;