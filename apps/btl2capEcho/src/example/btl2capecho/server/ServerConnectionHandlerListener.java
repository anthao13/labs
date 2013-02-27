// Copyright 2004 Nokia Corporation.
//
// THIS SOURCE CODE IS PROVIDED 'AS IS', WITH NO WARRANTIES WHATSOEVER,
// EXPRESS OR IMPLIED, INCLUDING ANY WARRANTY OF MERCHANTABILITY, FITNESS
// FOR ANY PARTICULAR PURPOSE, OR ARISING FROM A COURSE OF DEALING, USAGE
// OR TRADE PRACTICE, RELATING TO THE SOURCE CODE OR ANY WARRANTY OTHERWISE
// ARISING OUT OF ANY PROPOSAL, SPECIFICATION, OR SAMPLE AND WITH NO
// OBLIGATION OF NOKIA TO PROVIDE THE LICENSEE WITH ANY MAINTENANCE OR
// SUPPORT. FURTHERMORE, NOKIA MAKES NO WARRANTY THAT EXERCISE OF THE
// RIGHTS GRANTED HEREUNDER DOES NOT INFRINGE OR MAY NOT CAUSE INFRINGEMENT
// OF ANY PATENT OR OTHER INTELLECTUAL PROPERTY RIGHTS OWNED OR CONTROLLED
// BY THIRD PARTIES
//
// Furthermore, information provided in this source code is preliminary,
// and may be changed substantially prior to final release. Nokia Corporation
// retains the right to make changes to this source code at
// any time, without notice. This source code is provided for informational
// purposes only.
//
// Nokia and Nokia Connecting People are registered trademarks of Nokia
// Corporation.
// Java and all Java-based marks are trademarks or registered trademarks of
// Sun Microsystems, Inc.
// Other product and company names mentioned herein may be trademarks or
// trade names of their respective owners.
//
// A non-exclusive, non-transferable, worldwide, limited license is hereby
// granted to the Licensee to download, print, reproduce and modify the
// source code. The licensee has the right to market, sell, distribute and
// make available the source code in original or modified form only when
// incorporated into the programs developed by the Licensee. No other
// license, express or implied, by estoppel or otherwise, to any other
// intellectual property rights is granted herein.


package example.btl2capecho.server;


public interface ServerConnectionHandlerListener
{
    // The handler's open succeeded. It can now be used for sending
    // and receiving messages.
    public void handleOpen(ServerConnectionHandler handler);


    // The hadler's open failed. It has closed any connections or
    // streams that were open. The handler should not be used anymore,
    // and should be discarded.
    public void handleOpenError(ServerConnectionHandler handler,
                                String errorMessage);


    // The handler got an inbound message.
    public void handleReceivedMessage(
                    ServerConnectionHandler handler,
                    byte[] messageBytes);


    // A message that had been previously queued for sending
    // (identified by id) by the handler, has been sent successfully.
    public void handleQueuedMessageWasSent(
                    ServerConnectionHandler handler,
                    Integer id);


    // The handler has closed its connections and streams.
    // The handler should not be used anymore, and should be discarded.
    // Only handlers which have previously called 'handleOpen' may
    // call 'handleClose', and only just once.
    public void handleClose(ServerConnectionHandler handler);


    // An error related to the handler occurred. The handler
    // has closed the connection, and the handler should no
    // longer be used.
    public void handleErrorClose(ServerConnectionHandler handler,
                                 String errorMessage);

}

