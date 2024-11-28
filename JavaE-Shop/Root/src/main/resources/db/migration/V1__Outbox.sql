CREATE TABLE "IntegrationEventLog" (
                                       "EventId" UUID PRIMARY KEY,
                                       "EventTypeName" TEXT NOT NULL,
                                       "State" INTEGER NOT NULL,
                                       "TimesSent" INTEGER NOT NULL,
                                       "CreationTime" TIMESTAMP WITH TIME ZONE NOT NULL,
                                       "Content" TEXT NOT NULL,
                                       "TransactionId" UUID NOT NULL
);
